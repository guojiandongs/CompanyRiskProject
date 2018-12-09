package com.example.administrator.riskprojects.tools;

import android.content.Context;

public interface Constants {

	String LoginState = "LoginState";
	String UserInfo = "UserInfo";
	String EmployeeList = "EmployeeList";
	String OfLineEmployeeList = "OfLineEmployeeList";
	String NAME = "NAME";
	String PWD = "PWD";
	String ADDHIDDENRECORD = "addhiddenRecord";
	String ADDRECHECK = "addrecheck";
	String ADDPIC = "addPic";
	String CARDRECORD = "cardRecord";
	// JSON status
	String Info = "content";
	String Value = "data";
	String Result = "type";
	String DB_NAME = "WeChat.db";
	String NET_ERROR = "当前为脱机状态！";
	String SAVE_DATA = "网络错误，数据已保存，有网时自动上报！";
	String PAGE = "1";
	String ROWS = "10";
	String ISUPERVISION = "1";

	// 外网地址
	String MAIN_ENGINE = "http://1.63.57.10:18070/";
	//String MAIN_ENGINE = "http://192.168.4.50:8070/";
	//String MAIN_ENGINE = "http://192.168.5.50:8070/";
	//String MAIN_ENGINE = "http://1.63.57.10:28070/";
	//String MAIN_ENGINE = "http://1.63.57.10:38070/";
	//String MAIN_ENGINE = "http://192.168.111.6:8070/";
	//String MAIN_ENGINE = "http://192.168.111.5:8070/";

	// 内网地址
	String INNER_MAIN_ENGINE = "123123";
	// 用户登录
	String Login_URL = "mobile/employeeMobileAction!employeeLogin.action";
	// 首页获取隐患统计数据
	String HOME_GET_HIDDENUM = "mobile/yesterdayHdStatisticsMobileAction!gethiddenDangerByMonth.action";
	// 首页获取隐患记录数据
	String HOME_GET_HIDDENRECORD = "mobile/yesterdayHdStatisticsMobileAction!getHiddenDangerRecordByTeam.action";
	// 获取隐患记录数据(挂牌督办)
	String GET_HIDDENRECORD = "mobile/hiddenDangerRecordMobileAction!findHiddenDangerRecord.action";
	// 各单位隐患统计查询接口
	String TEAMHDSTAISTICSDATAGRID = "mobile/yesterdayHdStatisticsMobileAction!teamHdStatisticsDataGrid.action";
	// 隐患汇总表查询接口
	String SUMARYMOBILE = "mobile/hiddenDangerSumaryMobileAction!findHiddenDangerSumReport.action";
	// 已删除隐患记录查询
	String DELETEMOBILE = "mobile/hiddenDangerSumaryMobileAction!findHiddenDangerSumReport.action";
	// 重复隐患记录查询
	String REPEATMOBILE = "mobile/hiddenDangerRepeatMobileAction!findHiddenDangerRepeat.action";
	// 隐患处理单位图表分析
	String DEPARTMENTSTATISTICSMOBILE = "mobile/hiddenDangerHandleDepartmentStatisticsMobileAction!findHiddenDangerDepartmentStatistics.action";
	// 隐患处理图表分析接口
	String HIDDENDANGERSPECIALSTATISTICS = "mobile/hiddenDangerHandleSpecialStatisticsMobileAction!findHiddenDangerSpecialStatistics.action";
	// 隐患年度图表分析接口
	String FINDHIDDENDANGERYEARCHARTSTATISTICS = "mobile/hiddenDangerYearChartStatisticsMobileAction!findHiddenDangerYearChartStatistics.action";
	// 隐患查询统计
	String QUERYSTATICMOBILE = "mobile/hiddenDangerQueryStaticMobileAction!findHiddenDangerQueryStatic.action";
	// 根据id获取隐患信息
	String HIDDENDANGERRECORD = "mobile/hiddenDangerRecordMobileAction!findHiddenDangerRecordById.action";
	// 获取部门/队组接口
	String GET_COLLIERYTEAM = "mobile/collieryTeamMobileAction!getCollieryTeamList.action";
	// 获取所属专业
	String GET_SPECIALTY = "mobile/specialtyMobileAction!getSpecialtyList.action";
	// 获取隐患类别
	String GET_RISKGRADE = "mobile/riskGradeMobileAction!getRiskGradeList.action";
	// 获取数据字典
	String GET_DATADICT = "mobile/dataDictMobileAction!getDataDictionaryList.action";
	// 获取班次
	String GET_CLASSNUMBER = "mobile/classNumberMobileAction!getClassNumberList.action";
	// 获取区域
	String GET_AREA = "mobile/areaMobileAction!getAreaList.action";
	// 删除隐患
	String DELETE_HIDDEN = "mobile/hiddenDangerRecordMobileAction!deleteHiddenDangerRecord.action";
	// 隐患下达查询
	String GET_HIDDENRELEASELIST = "mobile/hiddenDangerThreeFixMobileAction!findHiddenDangerThreeFix.action";
	// 隐患整改查询
	String GET_RECTIFICATIONLIST = "mobile/hiddenDangerRectifyMobileAction!findhiddenDangerRectify.action";
	// 隐患跟踪查询
	String GET_TRACKINGLIST = "mobile/hiddenDangerCarryOutMobileAction!findhiddenDangerCarryOut.action";
	// 隐患逾期查询
	String GET_OVERDUELIST = "mobile/hiddenDangerOutOfTimeMobileAction!findhiddenDangerOutTime.action";
	// 隐患逾期重启下达
	String HANDLEOUT_OVERDUELIST = "mobile/hiddenDangerOutOfTimeMobileAction!handleOutTime.action";
	// 隐患验收查询
	String GET_REVIEWLIST = "mobile/hiddenDangerRecheckMobileAction!findhiddenDangerRecheck.action";
	// 隐患跟踪记录查询列表
	String GET_FOLLINGRECORD = "mobile/hiddenFollingRecordMobileAction!findFollingRecordByThreeFixId.action";
	// 隐患跟踪记录添加
	String ADD_FOLLINGRECORD = "mobile/hiddenFollingRecordMobileAction!addHiddenFollingRecord.action";
	// 隐患跟踪记录修改
	String UPDATE_FOLLINGRECORD = "mobile/hiddenFollingRecordMobileAction!updateFollingRecord.action";
	// 隐患跟踪记录删除
	String DELETE_FOLLINGRECORD = "mobile/hiddenFollingRecordMobileAction!deleteFollingRecordById.action";
	// 隐患添加记录
	String ADD_HIDDENDANGERRECORD = "mobile/hiddenDangerRecordMobileAction!addHiddenDangerRecord.action";
	// 隐患修改记录
	String UPDATE_HIDDENDANGERRECORD = "mobile/hiddenDangerRecordMobileAction!updateHiddenDangerRecord.action";
	// 隐患验收
	String ADD_RECHECK = "mobile/hiddenDangerRecheckMobileAction!addRecheck.action";
	// 隐患整改
	String COMPLETERECTIFY = "mobile/hiddenDangerRectifyMobileAction!completeRectify.action";
	// 隐患下达
	String ADD_THREEFIXANDCONFIRM = "mobile/hiddenDangerThreeFixMobileAction!addThreeFixAndConfirm.action";
	// 首页下边统计详情接口
	String GET_HIDDENDANGERDETAILLIST = "mobile/yesterdayHdStatisticsMobileAction!getHiddenDangerDetailList.action";
	// 各单位隐患统计详情接口
	String GET_TEAMDETAILLIST = "mobile/yesterdayHdStatisticsMobileAction!getTeamDetailList.action";
	// 查询未消耗的数据
	String GET_NOTHANDLELIST = "mobile/hiddenDangerSumaryMobileAction!findHiddenDangerNotHandleList.action";
	// 获取整改人、跟踪人
	String GET_EMPLOYEELISTBYTEAMID = "mobile/collieryTeamMobileAction!getEmployeeListByTeamId.action";
	// 修改密码
	String UPDATE_PWD = "mobile/employeeMobileAction!editPwd.action";
	// 获取版本号和下载地址
	String UPDATE_VERSION = "mobile/employeeMobileAction!changeVersion.action";
	// 添加督办
	String ADD_SUPERVISIONRECORD = "mobile/hiddenSupervisionRecordMobileAction!addHiddenSupervisionRecord.action";
	// 督办列表查询
	String GET_SUPERVISIONRECORDLIST = "mobile/hiddenSupervisionRecordMobileAction!findSupervisionRecordByHiddenDangerId.action";
	//挂牌添加
	String ADD_GPHIDDENDANGER = "mobile/hiddenDangerRecordMobileAction!gpHiddenDangerRecord.action";
	//修改用户数据
	String UPDATE_PERSONINFO = "mobile/employeeMobileAction!editUserInfo.action";
	//主页获取近期销号、未整改记录
	String GET_XIAOHAOLIST = "mobile/yesterdayHdStatisticsMobileAction!getXiaoHaoList.action";
	//主页获取逾期隐患
	String GET_WITHINTHETIMELIST = "mobile/hiddenDangerOutOfTimeMobileAction!findhiddenDangerOutTime.action";
	//主页获待验收隐患
	String GET_FORACCEPTANCELIST = "mobile/hiddenDangerRecheckMobileAction!findhiddenDangerRecheck.action";
	//获取巡检记录
	String GET_CARDRECORDLIST = "mobile/cardRecordMobileAction!findCardRecordByUserId.action";
	//提交巡检记录
	String ADD_CARDRECORDLIST = "mobile/cardRecordMobileAction!addCardRecord.action";
	//图片上传
	String UPLOAD_PIC = "imageAction.upaction";
	//查询图片组
	String GET_PICLIST = "mobile/hiddenDangerRecordMobileAction!getHiddenDangerImageList.action";
	//查询打卡地点
	String GET_CARDBASICLIST = "mobile/cardBasicAction!getCardBasicList.action";
	//查询用户列表
	String GET_EMPLOYEELIST = "mobile/collieryTeamMobileAction!getEmployeeList.action";
	//查询系统时间
	String GET_SYSTEMTIME = "mobile/getTimeMobileAction!getTime.action";
	//删除隐患图片
	String DELETE_HIDDENPIC = "mobile/hiddenDangerRecordMobileAction!deleteHiddenDangerImageById.action";
	//添加查看记录
	String ADD_RECORDWATCH = "mobile/hiddenDangerRecordMobileAction!addRecordWatch.action";
	//获取辨识评估统计
	String GET_EVALUATIONCOUNT = "mobile/evaluationMobileAction!getEvaluationCount.action";
    //获取辨识评估统计
    String GET_EVALUATIONCOUNT_LIST = "mobile/evaluationMobileAction!getEvaluationListByType.action";

	public void addRecheck(Context context);
	public void addAddhiddenrecord(Context context);
}
