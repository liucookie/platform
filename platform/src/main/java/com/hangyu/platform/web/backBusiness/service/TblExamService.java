package com.hangyu.platform.web.backBusiness.service;

import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.global.PlatException;
import com.hangyu.platform.utils.CommonUtils;
import com.hangyu.platform.utils.DateUtils;
import com.hangyu.platform.web.backBusiness.dto.BmStaffTbl;
import com.hangyu.platform.web.backBusiness.dto.TblClassifyTest;
import com.hangyu.platform.web.backBusiness.dto.TblClasssify;
import com.hangyu.platform.web.backBusiness.dto.TblExam;
import com.hangyu.platform.web.backBusiness.dto.TblExamineereply;
import com.hangyu.platform.web.backBusiness.dto.TblPlan;
import com.hangyu.platform.web.backBusiness.dto.TblPlanexaminee;
import com.hangyu.platform.web.backBusiness.dto.TblTest;
import com.hangyu.platform.web.backBusiness.mapper.BmStaffTblMapper;
import com.hangyu.platform.web.backBusiness.mapper.TblClassifyTestMapper;
import com.hangyu.platform.web.backBusiness.mapper.TblClasssifyMapper;
import com.hangyu.platform.web.backBusiness.mapper.TblExamMapper;
import com.hangyu.platform.web.backBusiness.mapper.TblExamineereplyMapper;
import com.hangyu.platform.web.backBusiness.mapper.TblPlanMapper;
import com.hangyu.platform.web.backBusiness.mapper.TblPlanexamineeMapper;
import com.hangyu.platform.web.backBusiness.mapper.TblTestMapper;
import com.hangyu.platform.web.backBusiness.vo.AddExamVO;
import com.hangyu.platform.web.backBusiness.vo.ExamBody;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


/**
 * 试卷管理
 *
 * @auther liuXuan
 * @date 2020/4/7
 */
@Service
public class TblExamService {

    @Resource
    private TblExamMapper examMapper;

    @Resource
    private TblClasssifyMapper classsifyMapper;

    @Resource
    private TblTestMapper testMapper;

    @Resource
    private TblClassifyTestMapper classifyTestMapper;

    @Autowired
    private TblTestService testService;

    @Resource
    private TblPlanexamineeMapper examineeMapper;

    @Resource
    private TblPlanMapper planMapper;

    @Resource
    private BmStaffTblMapper staffTblMapper;

    @Resource
    private TblExamineereplyMapper replyMapper;



    /**
     * 查询所有试卷
     *
     * @return
     */
    public Map<String, Object> query(String name, Integer minScore, Integer maxScore, int pageNum, int pageSize) {
        Map<String, Object> map = new HashMap<>();
        int start = CommonUtils.getPageStart(pageNum, pageSize);
        List<TblExam> list = examMapper.select(name, minScore, maxScore, start, pageSize);
        int total = examMapper.selectTotal(name, minScore, maxScore);
        map.put(CommonFields.getData(), list);
        map.put(CommonFields.getTotal(), total);
        return map;
    }


    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    public TblExam queryById(int id) {
        checkIsUse(id);
        TblExam tbl = examMapper.selectByPrimaryKey(id);
        AddExamVO examVO = addExamVO(id);
        tbl.setExamVO(examVO);
        return tbl;
    }

    /**
     * 校验试卷有没有没考试计划引用过，若引用，不能删除和修改
     * @param id
     */
    private void checkIsUse(int id){
        //被考试计划抽到过的卷子，就不能改
        List<TblPlan> plans = planMapper.selectByExamId(id);
        if (CollectionUtils.isNotEmpty(plans)){
            throw new PlatException("该试卷已被计划考试中使用,无法修改!");
        }
    }

    private AddExamVO addExamVO(int id) {
        AddExamVO examVO = new AddExamVO();
        //查询出各种类型的题目数量，和分数
        //查询出类型表的数据
        List<TblClasssify> classsifyList = classsifyMapper.selectByExamId(id);
        classsifyList.forEach(classsify -> {
            //查询出题目的数量信息
            Map<String, Integer> map = queryQuestionCount(classsify.getId());
            if (StringUtils.equals("单选题", classsify.getTblType())) {
                examVO.setSingleCount(map.get("count"));
                examVO.setSingleScore(map.get("score"));
            } else if (StringUtils.equals("多选题", classsify.getTblType())) {
                examVO.setMultipleCount(map.get("count"));
                examVO.setMultipleScore(map.get("score"));
            } else if (StringUtils.equals("判断题", classsify.getTblType())) {
                examVO.setJudgeCount(map.get("count"));
                examVO.setJudgeScore(map.get("score"));
            } else {
                examVO.setFillCount(map.get("count"));
                examVO.setFillScore(map.get("score"));
            }
        });
        return examVO;
    }

    /**
     * 查询所有的试卷
     *
     * @return
     */
    public List<TblExam> queryAllExam() {
        List<TblExam> list = examMapper.queryAllExam();
        return list;
    }

    /**
     * 查询各种类型的题目数量和分数
     *
     * @param examId
     * @return
     */
    private Map<String, Integer> queryQuestionCount(int examId) {
        Map<String, Integer> map = new HashMap<>();
        //用id去classifyTest表中查询
        List<TblClassifyTest> classifyTestList = classifyTestMapper.selectByClassifyId(examId);
        map.put("count", CollectionUtils.isEmpty(classifyTestList) ? 0 : classifyTestList.size());
        map.put("score", CollectionUtils.isEmpty(classifyTestList) ? 0 : classifyTestList.get(0).getScore());
        return map;
    }

    /**
     * 查看试卷里的试题
     *
     * @param examId
     * @return
     */
    public List<TblTest> queryTest(int examId) {
        List<TblTest> list = testMapper.queryTestByExamId(examId);
        dealListTest(examId, list);
        return list;
    }

    private void dealListTest(int examId, List<TblTest> list) {
        //处理存储的试题
        list.forEach(tblTest -> {
            //选项
            String foranswers = tblTest.getForanswers();
            //正确答案
            String rightanswer = tblTest.getRightanswer();
            if (StringUtils.isNotEmpty(foranswers)) {
                List<String> answerList = Arrays.asList(StringUtils.split(foranswers, "&*"));
                tblTest.setOptions(answerList);
            }
            //填空或者多选，是有多个正确答案
            List<String> rightAnswerList = Arrays.asList(StringUtils.split(rightanswer, "&*"));
            tblTest.setRightAnswer(rightAnswerList);
            //查出每个试题的分数
            int score = classifyTestMapper.selectScore(examId, tblTest.getId());
            tblTest.setScore(score);
        });
    }

    /**
     * 随机抽卷子
     *
     * @param
     * @return
     */
    @Transactional
    public Map<String, Object> randomExam(String userId,Integer isNewStaff) {
        Map<String, Object> map = new HashMap<>();
        //1.从自测考试计划中抽取,0代表就是自测计划
        List<TblPlan> plans = planMapper.selectByIsTest(0,null);
        int temp = new Random().nextInt(plans.size());
        TblPlan plan = plans.get(temp);
        int examId = plan.getExamIds();

        List<TblTest> tblTests = testMapper.queryTestByExamId(examId);
        dealListTest(examId, tblTests);

        //抽到测试提后，需要将考生的信息加入到考生信息表
        TblPlanexaminee tblPlanexaminee = new TblPlanexaminee();
        tblPlanexaminee.setBmStaffTblStaffid(userId);
        tblPlanexaminee.setTblExamid(examId);
        tblPlanexaminee.setEntertime(DateUtils.getCurrentDate1());
        BmStaffTbl staffTbl = staffTblMapper.selectByUserId(userId);
        tblPlanexaminee.setUsername(null != staffTbl ? staffTbl.getUsername() : null);
        tblPlanexaminee.setIsenter(1);
        tblPlanexaminee.setPlanId(plan.getId());
        //是否是自测考试，0 不是，1是
        tblPlanexaminee.setIsTest(1);
        //是否是新员工考试
        if (null != isNewStaff && isNewStaff == 1){
            tblPlanexaminee.setIsNewStaffExam(1);
        }
        examineeMapper.insert(tblPlanexaminee);
        int examineeId = tblPlanexaminee.getId();
        //试卷总分
        TblExam exam = examMapper.selectByPrimaryKey(examId);
        int score = exam.getScore();

        map.put("id", examineeId);
        map.put("tipMinute", plan.getExamTiptime());
        map.put("minute", plan.getExamTime());
        map.put("score", score);
        map.put("examId", examId);
        map.put("planId", plan.getId());
        map.put("testList", tblTests);
        return map;
    }

    /**
     * 查看考试计划中的试题
     *
     * @param
     * @return
     */
    public Map<String, Object> planExam(int planId, String userId) {
        Map<String, Object> map = new HashMap<>();
        TblPlan plan = planMapper.selectByPrimaryKey(planId);
        int examId = plan.getExamIds();
        //处理试题
        List<TblTest> tblTests = testMapper.queryTestByExamId(examId);
        dealListTest(examId, tblTests);

        TblExam exam = examMapper.selectByPrimaryKey(examId);
        //时长
        int minute = plan.getExamTime();
        //试卷总分
        int score = exam.getScore();
        //查出此场考试，对应的examinee信息，就是存储成绩的表
        TblPlanexaminee tblPlanexaminees = examineeMapper.selectByUserId(plan.getId(), userId, plan.getExamIds());
        map.put("planId", planId);
        map.put("tipMinute", plan.getExamTiptime());
        map.put("minute", minute);
        map.put("score", score);
        map.put("testList", tblTests);
        map.put("examId", examId);
        map.put("id", tblPlanexaminees.getId());
        return map;
    }

    /**
     * 查看试卷记录，已经答过的考卷
     *
     * @param
     * @return
     */
    public Map<String, Object> queryExamDetail(int examineeId, String userId) {
        Map<String, Object> map = new HashMap<>();
        TblPlanexaminee tblPlanexaminee = examineeMapper.selectByPrimaryKey(examineeId);
        int examId = tblPlanexaminee.getTblExamid();
        //处理试题
        List<TblTest> tblTests = testMapper.queryTestByExamId(examId);
        dealListTest(examId, tblTests);
        TblPlan plan = planMapper.selectByPrimaryKey(tblPlanexaminee.getPlanId());
        TblExam exam = examMapper.selectByPrimaryKey(examId);
        //查询考生答题表，判断题目正确是否
        List<TblExamineereply> replyList = replyMapper.selectByUserId(userId, examineeId);
        for (TblTest test : tblTests) {
            test.setFlag(false);
            for (TblExamineereply reply : replyList) {
                //题型相等
                if (test.getId() == reply.getSpecifictestid()) {
                    //单选和判断都正确，所以得分
                    if (StringUtils.equals(reply.getReplycontent(), test.getRightanswer())) {
                        test.setFlag(true);
                    }
                    //设置员工答题的自己的答案
                    test.setUserReplyAnswer(reply.getReplycontent());
                    break;
                }
            }
        }
        //试卷总分
        int score = exam.getScore();
        map.put("examName", exam.getName());
        map.put("minute", plan.getExamTime());
        map.put("score", score);
        map.put("userScore", tblPlanexaminee.getScore());
        map.put("testList", tblTests);
        return map;
    }


    /**
     * 交卷
     *
     * @param examBody
     * @return
     */
    @Transactional
    public Map<String, Object> handExam(ExamBody examBody) {
        Map<String, Object> map = new HashMap<>();
        //本次考试的id
        int examineerId = examBody.getId();
        //考生答题表
        List<TblExamineereply> tblExamineereplyList = new ArrayList<>();
        List<ExamBody.Test> testList = examBody.getTestList();
        //循环遍历考生的试卷，计算分数，加入到考生表中、
        int score = 0;  //总得分
        for (ExamBody.Test test : testList) {
            // 试题id
            int testId = test.getTestId();
            String replyContent = test.getReplyContent();
            //原试题
            TblTest tblTest = testMapper.selectByPrimaryKey(testId);
            String rightAnswer = tblTest.getRightanswer();
            //单选和判断都正确，所以得分
            if (StringUtils.equals(replyContent, rightAnswer)) {
                score += test.getScore();
            }
            //加入到考生答题表中
            TblExamineereply tblExamineereply = new TblExamineereply(examBody.getUserId(), test.getTestId(),
                    examBody.getPlanId(), test.getReplyContent(), test.getType(), examBody.getExamId(),examineerId);
            tblExamineereplyList.add(tblExamineereply);
        }
        //加入到tbl_examineerply,考生答题表
        replyMapper.insertBatch(tblExamineereplyList);
        //根据答分情况，设置，是否优秀
        TblPlan plan = planMapper.selectByPrimaryKey(examBody.getPlanId());
        TblExam exam = examMapper.selectByPrimaryKey(examBody.getExamId());
        int totalScore = exam.getScore();
        int examResult;
        String result;
        //0不及格 1及格 2 良好 3 优秀 4未考试
        if (score < (Double.valueOf(("0." + plan.getPassScore())) * totalScore)) {
            examResult = 0;
            result = "不及格";
        } else if (score >= (Double.valueOf(("0." + plan.getPassScore())) * totalScore) && score < (Double.valueOf(("0." + plan.getWellScore())) * totalScore)) {
            examResult = 1;
            result = "及格";
        } else if (score >= (Double.valueOf(("0." + plan.getWellScore())) * totalScore) && score < (Double.valueOf(("0." + plan.getGoodScore())) * totalScore)) {
            examResult = 2;
            result = "良好";
        } else {
            examResult = 3;
            result = "优秀";
        }
        //更新TblExaminee表
        TblPlanexaminee tblPlanexaminee = examineeMapper.selectByPrimaryKey(examineerId);
        // 1 表示已经进入考试和，参加考试
        tblPlanexaminee.setIsenter(1);
        tblPlanexaminee.setState(1);
        tblPlanexaminee.setExamresult(examResult);
        tblPlanexaminee.setScore(score);
        //设置开始考试时间
        tblPlanexaminee.setEntertime(examBody.getStartTime());
        examineeMapper.updateByPrimaryKey(tblPlanexaminee);

        planMapper.updateCount(examBody.getPlanId());
        map.put("result", result);
        map.put("examName", exam.getName());
        map.put("score", score + "/" + exam.getScore());
        return map;
    }


    /**
     * 增加
     *
     * @param info
     */
    @Transactional
    public void add(TblExam info) {
        info.setIsoriginal(0);
        //先增加主表 tbl_exam
        examMapper.insert(info);
        //试卷主键
        int examId = info.getId();
        //增加tbl_classify，看都有什么题型，有就抽题加表
        addClassifyAndTest(examId, info.getExamVO());
    }

    private void addClassifyAndTest(int examId, AddExamVO examVO) {
        //单选题
        if (examVO.getSingleCount() > 0) {
            //增加后的主键
            int classifyId = addClassify(examId, "单选题");
            //单选题的数量，然后从题库里抽题
            addClassifyTestBatch("单选题", examVO.getSingleCount(), classifyId, examVO.getSingleScore());
        }
        //多选题
        if (examVO.getMultipleCount() > 0) {
            //增加后的主键
            int classifyId = addClassify(examId, "多选题");
            //多选题的数量，然后从题库里抽题
            addClassifyTestBatch("多选题", examVO.getMultipleCount(), classifyId, examVO.getMultipleScore());
        }
        //判断题
        if (examVO.getJudgeCount() > 0) {
            //增加后的主键
            int classifyId = addClassify(examId, "判断题");
            //判断题的数量，然后从题库里抽题
            addClassifyTestBatch("判断题", examVO.getJudgeCount(), classifyId, examVO.getJudgeScore());
        }
        //填空题
        if (examVO.getFillCount() > 0) {
            //增加后的主键
            int classifyId = addClassify(examId, "填空题");
            //单选题的数量，然后从题库里抽题
            addClassifyTestBatch("填空题", examVO.getFillCount(), classifyId, examVO.getFillScore());
        }
    }

    /**
     * 加入到classify表中，返回增加的主键
     *
     * @param examId 试卷id
     * @return
     */
    private int addClassify(int examId, String type) {
        TblClasssify classsify = new TblClasssify();
        classsify.setTblExamid(examId);
        classsify.setTblType(type);
        classsifyMapper.insert(classsify);
        return classsify.getId();
    }

    /**
     * 存储到 tblClassifyTest表
     *
     * @param type       类型
     * @param count      抽题 的数量
     * @param ClassifyId 类别id
     * @param score      分数
     */
    private void addClassifyTestBatch(String type, int count, int ClassifyId, int score) {
        //判断抽取的题目数量，是否大于题库中的数量
        int questionCount = testMapper.selectTotal(type, null);
        if (count > questionCount) {
            throw new PlatException("所填写的题目类型数量,大于题库中的题目类型数量!");
        }
        //根据类型和数量，查询题库里的题目
        List<TblTest> list = testService.queryByType(type, null);
        //抽取出来的题
        List<TblTest> newlist = getRandomList(list, count);
        List<TblClassifyTest> classifyTestList = new ArrayList<>();
        //将抽取到的题目，更新抽到次数
        testMapper.updateBatch(newlist);
        newlist.forEach(test -> {
            //存储到classify_test表中
            TblClassifyTest classifyTest = new TblClassifyTest();
            classifyTest.setClassifyid(ClassifyId);
            //试题id
            classifyTest.setTestid(test.getId());
            classifyTest.setScore(score);
            classifyTestList.add(classifyTest);
        });
        classifyTestMapper.insertBatch(classifyTestList);
    }

    /**
     * 从list中随机抽取若干不重复元素
     *
     * @param paramList:被抽取list
     * @param count:抽取元素的个数     由抽取元素组成的新list
     */
    public List getRandomList(List<TblTest> paramList, int count) {
        Random random = new Random();
        //临时存放产生的list索引，去除重复的索引
        List<Integer> tempList = new ArrayList<>();
        //生成新的list集合
        List<TblTest> newList = new ArrayList<>();
        int temp = 0;
        if (count <= 1) {
            //如果数据小于1，取一条数据,nextInt生成的随机数，参数传的是不超过这个数的最大值
            temp = random.nextInt(paramList.size());
            newList.add(paramList.get(temp));
        } else {
            for (int i = 0; i < count; i++) {
                //初始化一个随机数，将产生的随机数作为被抽list的索引
                temp = random.nextInt(paramList.size());
                //判断随机抽取的随机数，防止重复抽取
                if (!tempList.contains(temp)) {
                    //已经抽取到的随机数
                    tempList.add(temp);
                    newList.add(paramList.get(temp));
                } else {
                    i--;
                }
            }
        }
        return newList;
    }


    /**
     * 修改
     *
     * @param info
     */
    @Transactional
    public void update(TblExam info) {
        //更新主表
        examMapper.updateByPrimaryKey(info);
        //删除classify,classifytest表的数据
        deleteClassifyAndTest(info.getId());
        //重新增加数据
        addClassifyAndTest(info.getId(), info.getExamVO());
    }

    /**
     * 删除
     *
     * @param id 试卷id
     */
    @Transactional
    public void delete(int id) {
        checkIsUse(id);
        examMapper.deleteByPrimaryKey(id);
        deleteClassifyAndTest(id);
    }

    private void deleteClassifyAndTest(int examId) {
        //删除tbl_classifty表
        //用examid查询出所有的数据
        List<TblClasssify> classsifyList = classsifyMapper.selectByExamId(examId);
        classsifyMapper.deleteByExamId(examId);
        //删除tbl_classifyTest表
        classsifyList.forEach(classsify -> {
            classifyTestMapper.deleteByClassifyId(classsify.getId());
        });
    }

}
