package com.lingang.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @name LinGang
 * @class name：com.lingang.bean
 * @class describe
 * @anthor Administrator
 * @time 2017/6/28 0028 13:35
 * @change
 * @chang time
 * @class describe
 */
public class GroupConnectionBean{

    /**
     * message :
     * Data : [{"IssubNode":"0","IsJob":"2","GroupCD":"F3C4F2B2-87AB-43DA-A5F7-1DDA37B511DB","GroupName":"董事长室","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"1","GroupCode":"","GroupNumberCode":"","GroupIsDelete":"0","GroupCreater":"","GroupCreateDateTime":"","GroupUpdater":"","GroupUpdateDateTime":"","GroupIsFunction":"0","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"","GroupCreaterName":"","GroupUpdaterName":"","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"0","IsJob":"7","GroupCD":"4AC11AC0-5B8F-4FC7-AE8F-7B883246649A","GroupName":"总裁室","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"3","GroupCode":"","GroupNumberCode":"","GroupIsDelete":"0","GroupCreater":"","GroupCreateDateTime":"","GroupUpdater":"","GroupUpdateDateTime":"","GroupIsFunction":"0","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"","GroupCreaterName":"","GroupUpdaterName":"","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"0","IsJob":"9","GroupCD":"08E2EB7C-4888-4FBD-8BEB-D28A79B35ADA","GroupName":"党委","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"4","GroupCode":"","GroupNumberCode":"","GroupIsDelete":"0","GroupCreater":"","GroupCreateDateTime":"","GroupUpdater":"","GroupUpdateDateTime":"","GroupIsFunction":"0","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"","GroupCreaterName":"","GroupUpdaterName":"","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"0","IsJob":"9","GroupCD":"1782751E-B2C1-42FF-B4AD-B9462966CBBE","GroupName":"纪委","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"5","GroupCode":"","GroupNumberCode":"","GroupIsDelete":"0","GroupCreater":"","GroupCreateDateTime":"","GroupUpdater":"","GroupUpdateDateTime":"","GroupIsFunction":"0","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"","GroupCreaterName":"","GroupUpdaterName":"","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"0","IsJob":"4","GroupCD":"34A115D4-5E3F-46B6-B14F-03E52DBF54E9","GroupName":"总师室","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"6","GroupCode":"","GroupNumberCode":"","GroupIsDelete":"0","GroupCreater":"","GroupCreateDateTime":"","GroupUpdater":"","GroupUpdateDateTime":"","GroupIsFunction":"0","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"","GroupCreaterName":"","GroupUpdaterName":"","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"0","IsJob":"23","GroupCD":"FF8BDB73-3E30-4031-B006-20618387EE45","GroupName":"外派经理管理中心","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"7","GroupCode":"","GroupNumberCode":"WPJL","GroupIsDelete":"0","GroupCreater":"","GroupCreateDateTime":"","GroupUpdater":"0318F338-CA93-45EF-88E8-BECD6EA42663","GroupUpdateDateTime":"2014/5/23 15:25:03","GroupIsFunction":"0","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"","GroupCreaterName":"","GroupUpdaterName":"赵东春","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"0","IsJob":"7","GroupCD":"8038E59C-82E9-4B6F-BCA1-44619062103C","GroupName":"审计管理中心","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"8","GroupCode":"","GroupNumberCode":"SJGLZX","GroupIsDelete":"0","GroupCreater":"0318F338-CA93-45EF-88E8-BECD6EA42663","GroupCreateDateTime":"2014/5/23 15:26:01","GroupUpdater":"0318F338-CA93-45EF-88E8-BECD6EA42663","GroupUpdateDateTime":"2014/5/23 15:26:01","GroupIsFunction":"0","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"","GroupCreaterName":"赵东春","GroupUpdaterName":"赵东春","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"0","IsJob":"30","GroupCD":"8AEFF00E-F1E7-4115-89B3-DAD45FEC5F06","GroupName":"财务管理中心","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"9","GroupCode":"","GroupNumberCode":"wpcw","GroupIsDelete":"0","GroupCreater":"35C84B55-540A-405D-9D9F-61C83728A666","GroupCreateDateTime":"2014/6/19 10:27:48","GroupUpdater":"35C84B55-540A-405D-9D9F-61C83728A666","GroupUpdateDateTime":"2017/2/14 9:36:59","GroupIsFunction":"1","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"","GroupCreaterName":"黄渊","GroupUpdaterName":"黄渊","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"0","IsJob":"8","GroupCD":"4C9CF737-6EFC-43FE-932F-BAC7B0D4105D","GroupName":"规划设计管理中心","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"10","GroupCode":"","GroupNumberCode":"SJZX","GroupIsDelete":"0","GroupCreater":"0318F338-CA93-45EF-88E8-BECD6EA42663","GroupCreateDateTime":"2015/11/13 14:05:46","GroupUpdater":"0318F338-CA93-45EF-88E8-BECD6EA42663","GroupUpdateDateTime":"2015/11/13 14:07:30","GroupIsFunction":"0","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"","GroupCreaterName":"赵东春","GroupUpdaterName":"赵东春","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"0","IsJob":"9","GroupCD":"E82CA539-620B-45DB-B153-FFFA90994602","GroupName":"经营管理部(集团统计中心)","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"11","GroupCode":"","GroupNumberCode":"007","GroupIsDelete":"0","GroupCreater":"","GroupCreateDateTime":"","GroupUpdater":"35C84B55-540A-405D-9D9F-61C83728A666","GroupUpdateDateTime":"2017/6/15 11:11:56","GroupIsFunction":"1","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"经","GroupCreaterName":"","GroupUpdaterName":"黄渊","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"0","IsJob":"5","GroupCD":"8FAD9EAD-2A9D-43C2-81B0-98D897177D32","GroupName":"审计室","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"12","GroupCode":"","GroupNumberCode":"","GroupIsDelete":"0","GroupCreater":"","GroupCreateDateTime":"","GroupUpdater":"","GroupUpdateDateTime":"","GroupIsFunction":"1","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"审","GroupCreaterName":"","GroupUpdaterName":"","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"0","IsJob":"1","GroupCD":"124FE37E-8EC2-4A56-A35B-3FA56BB5F11E","GroupName":"监察室","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"13","GroupCode":"","GroupNumberCode":"0555","GroupIsDelete":"0","GroupCreater":"35C84B55-540A-405D-9D9F-61C83728A666","GroupCreateDateTime":"2016/2/29 11:00:00","GroupUpdater":"35C84B55-540A-405D-9D9F-61C83728A666","GroupUpdateDateTime":"2017/6/15 11:12:18","GroupIsFunction":"1","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"监","GroupCreaterName":"黄渊","GroupUpdaterName":"黄渊","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"3","IsJob":"19","GroupCD":"3C1B28FE-E893-4B3B-842F-3E06ED0F9624","GroupName":"行政管理部","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"14","GroupCode":"","GroupNumberCode":"","GroupIsDelete":"0","GroupCreater":"","GroupCreateDateTime":"","GroupUpdater":"","GroupUpdateDateTime":"","GroupIsFunction":"1","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"行","GroupCreaterName":"","GroupUpdaterName":"","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"5","IsJob":"77","GroupCD":"D7C5ADAA-C40B-4D16-B849-DCE6DC5833A2","GroupName":"财务金融部","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"15","GroupCode":"","GroupNumberCode":"JTBB-CW","GroupIsDelete":"0","GroupCreater":"","GroupCreateDateTime":"","GroupUpdater":"35C84B55-540A-405D-9D9F-61C83728A666","GroupUpdateDateTime":"2016/1/6 14:26:22","GroupIsFunction":"1","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"财","GroupCreaterName":"","GroupUpdaterName":"黄渊","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"0","IsJob":"11","GroupCD":"F5F819CF-6BC1-482C-A7F2-DD9A226DB054","GroupName":"人力资源部","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"16","GroupCode":"","GroupNumberCode":"","GroupIsDelete":"0","GroupCreater":"","GroupCreateDateTime":"","GroupUpdater":"","GroupUpdateDateTime":"","GroupIsFunction":"1","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"人","GroupCreaterName":"","GroupUpdaterName":"","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"0","IsJob":"12","GroupCD":"4FB50D47-CCD8-4B0A-9694-F01024DFBE6A","GroupName":"科创和产业发展办公室","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"17","GroupCode":"","GroupNumberCode":"006","GroupIsDelete":"0","GroupCreater":"","GroupCreateDateTime":"","GroupUpdater":"35C84B55-540A-405D-9D9F-61C83728A666","GroupUpdateDateTime":"2017/6/15 11:12:48","GroupIsFunction":"1","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"科","GroupCreaterName":"","GroupUpdaterName":"黄渊","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"0","IsJob":"8","GroupCD":"311CAFA1-1295-4C59-A584-698A5C06E41B","GroupName":"规划发展部","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"18","GroupCode":"","GroupNumberCode":"","GroupIsDelete":"0","GroupCreater":"","GroupCreateDateTime":"","GroupUpdater":"","GroupUpdateDateTime":"","GroupIsFunction":"1","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"规","GroupCreaterName":"","GroupUpdaterName":"","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"3","IsJob":"19","GroupCD":"D4697C03-BA1E-44CD-B5AE-270CAADE2F88","GroupName":"工程建设部","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"19","GroupCode":"GC","GroupNumberCode":"GC","GroupIsDelete":"0","GroupCreater":"","GroupCreateDateTime":"","GroupUpdater":"","GroupUpdateDateTime":"","GroupIsFunction":"1","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"工","GroupCreaterName":"","GroupUpdaterName":"","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"5","IsJob":"29","GroupCD":"499DF5C2-CA73-4112-B071-702FBAB7A20B","GroupName":"招商服务中心","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"20","GroupCode":"","GroupNumberCode":"","GroupIsDelete":"0","GroupCreater":"","GroupCreateDateTime":"","GroupUpdater":"","GroupUpdateDateTime":"","GroupIsFunction":"1","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"招","GroupCreaterName":"","GroupUpdaterName":"","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"0","IsJob":"35","GroupCD":"75C7B68F-234F-4747-93EA-87CD03822677","GroupName":"投资发展部","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"21","GroupCode":"","GroupNumberCode":"","GroupIsDelete":"0","GroupCreater":"","GroupCreateDateTime":"","GroupUpdater":"","GroupUpdateDateTime":"","GroupIsFunction":"1","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"投","GroupCreaterName":"","GroupUpdaterName":"","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"0","IsJob":"19","GroupCD":"F6702CB2-1D66-4551-A527-F1DE7CD7452C","GroupName":"信息管理部","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"22","GroupCode":"","GroupNumberCode":"167","GroupIsDelete":"0","GroupCreater":"35C84B55-540A-405D-9D9F-61C83728A666","GroupCreateDateTime":"2016/7/15 11:18:12","GroupUpdater":"35C84B55-540A-405D-9D9F-61C83728A666","GroupUpdateDateTime":"2016/9/2 13:21:46","GroupIsFunction":"1","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"信","GroupCreaterName":"黄渊","GroupUpdaterName":"黄渊","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"0","IsJob":"7","GroupCD":"7BAB2F7D-F5FC-463B-A7EF-6391A3FFBAFD","GroupName":"战略发展部","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"23","GroupCode":"","GroupNumberCode":"","GroupIsDelete":"0","GroupCreater":"","GroupCreateDateTime":"","GroupUpdater":"","GroupUpdateDateTime":"","GroupIsFunction":"1","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"战略","GroupCreaterName":"","GroupUpdaterName":"","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"0","IsJob":"7","GroupCD":"1C4E0CE3-ED8A-488E-B0B3-CFEDA62F69D9","GroupName":"安全质监部","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"24","GroupCode":"","GroupNumberCode":"0666","GroupIsDelete":"0","GroupCreater":"","GroupCreateDateTime":"","GroupUpdater":"35C84B55-540A-405D-9D9F-61C83728A666","GroupUpdateDateTime":"2017/6/15 11:19:21","GroupIsFunction":"1","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"安","GroupCreaterName":"","GroupUpdaterName":"黄渊","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"0","IsJob":"11","GroupCD":"CBDB11AE-3622-49A0-924A-74CAD78250C6","GroupName":"物流贸易部","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"25","GroupCode":"","GroupNumberCode":"","GroupIsDelete":"0","GroupCreater":"","GroupCreateDateTime":"","GroupUpdater":"","GroupUpdateDateTime":"","GroupIsFunction":"1","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"物","GroupCreaterName":"","GroupUpdaterName":"","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"0","IsJob":"14","GroupCD":"776A8803-EF2F-4C2F-957C-97D72B73377B","GroupName":"科技部","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"26","GroupCode":"","GroupNumberCode":"科","GroupIsDelete":"0","GroupCreater":"0318F338-CA93-45EF-88E8-BECD6EA42663","GroupCreateDateTime":"2013/6/21 11:53:49","GroupUpdater":"0318F338-CA93-45EF-88E8-BECD6EA42663","GroupUpdateDateTime":"2013/6/21 11:53:49","GroupIsFunction":"0","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"","GroupCreaterName":"赵东春","GroupUpdaterName":"赵东春","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"0","IsJob":"7","GroupCD":"F1D26442-24CA-45EB-AC51-0B9CD77EF42B","GroupName":"园区管理部","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"27","GroupCode":"","GroupNumberCode":"LGYQ","GroupIsDelete":"0","GroupCreater":"0318F338-CA93-45EF-88E8-BECD6EA42663","GroupCreateDateTime":"2013/8/7 20:42:29","GroupUpdater":"35C84B55-540A-405D-9D9F-61C83728A666","GroupUpdateDateTime":"2017/6/15 11:14:14","GroupIsFunction":"1","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"园","GroupCreaterName":"赵东春","GroupUpdaterName":"黄渊","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"0","IsJob":"7","GroupCD":"74A3375B-D37D-4B38-B0CF-1DE2574B48C9","GroupName":"人才服务中心","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"28","GroupCode":"","GroupNumberCode":"LGRC","GroupIsDelete":"0","GroupCreater":"0318F338-CA93-45EF-88E8-BECD6EA42663","GroupCreateDateTime":"2013/8/7 20:42:57","GroupUpdater":"0318F338-CA93-45EF-88E8-BECD6EA42663","GroupUpdateDateTime":"2013/8/7 20:43:29","GroupIsFunction":"1","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"","GroupCreaterName":"赵东春","GroupUpdaterName":"赵东春","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"0","IsJob":"11","GroupCD":"281FFD2D-17F8-4DDE-B11D-1D14E5FD82CB","GroupName":"大丰园区办公室","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"29","GroupCode":"","GroupNumberCode":"087","GroupIsDelete":"0","GroupCreater":"35C84B55-540A-405D-9D9F-61C83728A666","GroupCreateDateTime":"2015/8/11 9:52:14","GroupUpdater":"35C84B55-540A-405D-9D9F-61C83728A666","GroupUpdateDateTime":"2017/6/15 11:22:21","GroupIsFunction":"0","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"大丰","GroupCreaterName":"黄渊","GroupUpdaterName":"黄渊","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"0","IsJob":"12","GroupCD":"DF9E7E98-13C8-4D00-8484-8D532BA14878","GroupName":"机关党委","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"30","GroupCode":"","GroupNumberCode":"","GroupIsDelete":"0","GroupCreater":"","GroupCreateDateTime":"","GroupUpdater":"","GroupUpdateDateTime":"","GroupIsFunction":"1","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"","GroupCreaterName":"","GroupUpdaterName":"","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"0","IsJob":"5","GroupCD":"1AEBAB81-4C40-4DC5-A56F-D97893EA4341","GroupName":"干部处","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"31","GroupCode":"","GroupNumberCode":"","GroupIsDelete":"0","GroupCreater":"","GroupCreateDateTime":"","GroupUpdater":"0318F338-CA93-45EF-88E8-BECD6EA42663","GroupUpdateDateTime":"2012/12/26 10:28:17","GroupIsFunction":"1","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"干","GroupCreaterName":"","GroupUpdaterName":"","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"0","IsJob":"6","GroupCD":"39D04EB3-8267-4DEC-AFB7-2F7833960B77","GroupName":"组织处","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"32","GroupCode":"","GroupNumberCode":"","GroupIsDelete":"0","GroupCreater":"","GroupCreateDateTime":"","GroupUpdater":"0318F338-CA93-45EF-88E8-BECD6EA42663","GroupUpdateDateTime":"2012/12/26 10:28:44","GroupIsFunction":"1","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"组","GroupCreaterName":"","GroupUpdaterName":"","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"0","IsJob":"4","GroupCD":"E8BCF22E-27B4-4E6D-83B8-8F544C1108CF","GroupName":"党委办公室","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"33","GroupCode":"","GroupNumberCode":"","GroupIsDelete":"0","GroupCreater":"","GroupCreateDateTime":"","GroupUpdater":"","GroupUpdateDateTime":"","GroupIsFunction":"1","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"","GroupCreaterName":"","GroupUpdaterName":"","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"0","IsJob":"14","GroupCD":"1D7BEC52-1929-4F85-99A1-88CEE09EFDD8","GroupName":"集团工会","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"34","GroupCode":"","GroupNumberCode":"","GroupIsDelete":"0","GroupCreater":"","GroupCreateDateTime":"","GroupUpdater":"","GroupUpdateDateTime":"","GroupIsFunction":"1","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"工会","GroupCreaterName":"","GroupUpdaterName":"","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"0","IsJob":"14","GroupCD":"CBFCCB20-3E1A-4A6E-ABB1-4E8F69084856","GroupName":"企业协会","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"35","GroupCode":"","GroupNumberCode":"qyxh","GroupIsDelete":"0","GroupCreater":"","GroupCreateDateTime":"","GroupUpdater":"35C84B55-540A-405D-9D9F-61C83728A666","GroupUpdateDateTime":"2017/6/15 11:22:09","GroupIsFunction":"0","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"协会","GroupCreaterName":"","GroupUpdaterName":"黄渊","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"3","IsJob":"8","GroupCD":"52F27CBA-63A8-4550-B6C3-22CC9DD6CA5F","GroupName":"临港创新管理学院","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"36","GroupCode":"","GroupNumberCode":"cxglxy","GroupIsDelete":"0","GroupCreater":"35C84B55-540A-405D-9D9F-61C83728A666","GroupCreateDateTime":"2016/12/13 13:41:59","GroupUpdater":"35C84B55-540A-405D-9D9F-61C83728A666","GroupUpdateDateTime":"2017/6/15 11:21:26","GroupIsFunction":"0","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"学院","GroupCreaterName":"黄渊","GroupUpdaterName":"黄渊","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"0","IsJob":"11","GroupCD":"FD869ED5-BE70-446B-8EA7-4551501612E5","GroupName":"团委","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"集团团委","GroupOrder":"37","GroupCode":"","GroupNumberCode":"","GroupIsDelete":"0","GroupCreater":"","GroupCreateDateTime":"","GroupUpdater":"","GroupUpdateDateTime":"","GroupIsFunction":"1","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"","GroupCreaterName":"","GroupUpdaterName":"","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"0","IsJob":"2","GroupCD":"198D8811-C24A-42D0-81D7-270DBDFC62E5","GroupName":"医务室","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"38","GroupCode":"","GroupNumberCode":"","GroupIsDelete":"0","GroupCreater":"","GroupCreateDateTime":"","GroupUpdater":"","GroupUpdateDateTime":"","GroupIsFunction":"0","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"","GroupCreaterName":"","GroupUpdaterName":"","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""},{"IssubNode":"0","IsJob":"30","GroupCD":"D1669AD9-319D-452C-B9E2-74D5EF221CD9","GroupName":"车队","GroupENName":"","GroupParentCD":"75231AA6-6CBC-4B07-804E-A78CDE9777D6","GroupAscription":"0","GroupType":"1","GroupLevel":"2","GroupArea":"","GroupMemo":"","GroupOrder":"39","GroupCode":"","GroupNumberCode":"","GroupIsDelete":"0","GroupCreater":"","GroupCreateDateTime":"","GroupUpdater":"0318F338-CA93-45EF-88E8-BECD6EA42663","GroupUpdateDateTime":"2012/7/6 15:21:52","GroupIsFunction":"0","GroupManageJob":"","GroupFullName":"","GroupDispatchCode":"","GroupCreaterName":"","GroupUpdaterName":"","GroupViewRightID":"everyone","GroupViewRightName":"全体员工","GroupIsVisible":"1","GroupFlowPrefix":"","GroupRelationCompany":""}]
     */

    private String message;
    private List<DataBean> Data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return Data;
    }

    public void setData(List<DataBean> Data) {
        this.Data = Data;
    }

    public static class DataBean{
        /**
         * IssubNode : 0
         * IsJob : 2
         * GroupCD : F3C4F2B2-87AB-43DA-A5F7-1DDA37B511DB
         * GroupName : 董事长室
         * GroupENName :
         * GroupParentCD : 75231AA6-6CBC-4B07-804E-A78CDE9777D6
         * GroupAscription : 0
         * GroupType : 1
         * GroupLevel : 2
         * GroupArea :
         * GroupMemo :
         * GroupOrder : 1
         * GroupCode :
         * GroupNumberCode :
         * GroupIsDelete : 0
         * GroupCreater :
         * GroupCreateDateTime :
         * GroupUpdater :
         * GroupUpdateDateTime :
         * GroupIsFunction : 0
         * GroupManageJob :
         * GroupFullName :
         * GroupDispatchCode :
         * GroupCreaterName :
         * GroupUpdaterName :
         * GroupViewRightID : everyone
         * GroupViewRightName : 全体员工
         * GroupIsVisible : 1
         * GroupFlowPrefix :
         * GroupRelationCompany :
         */

        private String IssubNode;
        private String IsJob;
        private String GroupCD;
        private String GroupName;
        private String GroupENName;
        private String GroupParentCD;
        private String GroupAscription;
        private String GroupType;
        private String GroupLevel;
        private String GroupArea;
        private String GroupMemo;
        private String GroupOrder;
        private String GroupCode;
        private String GroupNumberCode;
        private String GroupIsDelete;
        private String GroupCreater;
        private String GroupCreateDateTime;
        private String GroupUpdater;
        private String GroupUpdateDateTime;
        private String GroupIsFunction;
        private String GroupManageJob;
        private String GroupFullName;
        private String GroupDispatchCode;
        private String GroupCreaterName;
        private String GroupUpdaterName;
        private String GroupViewRightID;
        private String GroupViewRightName;
        private String GroupIsVisible;
        private String GroupFlowPrefix;
        private String GroupRelationCompany;

        public String getIssubNode() {
            return IssubNode;
        }

        public void setIssubNode(String IssubNode) {
            this.IssubNode = IssubNode;
        }

        public String getIsJob() {
            return IsJob;
        }

        public void setIsJob(String IsJob) {
            this.IsJob = IsJob;
        }

        public String getGroupCD() {
            return GroupCD;
        }

        public void setGroupCD(String GroupCD) {
            this.GroupCD = GroupCD;
        }

        public String getGroupName() {
            return GroupName;
        }

        public void setGroupName(String GroupName) {
            this.GroupName = GroupName;
        }

        public String getGroupENName() {
            return GroupENName;
        }

        public void setGroupENName(String GroupENName) {
            this.GroupENName = GroupENName;
        }

        public String getGroupParentCD() {
            return GroupParentCD;
        }

        public void setGroupParentCD(String GroupParentCD) {
            this.GroupParentCD = GroupParentCD;
        }

        public String getGroupAscription() {
            return GroupAscription;
        }

        public void setGroupAscription(String GroupAscription) {
            this.GroupAscription = GroupAscription;
        }

        public String getGroupType() {
            return GroupType;
        }

        public void setGroupType(String GroupType) {
            this.GroupType = GroupType;
        }

        public String getGroupLevel() {
            return GroupLevel;
        }

        public void setGroupLevel(String GroupLevel) {
            this.GroupLevel = GroupLevel;
        }

        public String getGroupArea() {
            return GroupArea;
        }

        public void setGroupArea(String GroupArea) {
            this.GroupArea = GroupArea;
        }

        public String getGroupMemo() {
            return GroupMemo;
        }

        public void setGroupMemo(String GroupMemo) {
            this.GroupMemo = GroupMemo;
        }

        public String getGroupOrder() {
            return GroupOrder;
        }

        public void setGroupOrder(String GroupOrder) {
            this.GroupOrder = GroupOrder;
        }

        public String getGroupCode() {
            return GroupCode;
        }

        public void setGroupCode(String GroupCode) {
            this.GroupCode = GroupCode;
        }

        public String getGroupNumberCode() {
            return GroupNumberCode;
        }

        public void setGroupNumberCode(String GroupNumberCode) {
            this.GroupNumberCode = GroupNumberCode;
        }

        public String getGroupIsDelete() {
            return GroupIsDelete;
        }

        public void setGroupIsDelete(String GroupIsDelete) {
            this.GroupIsDelete = GroupIsDelete;
        }

        public String getGroupCreater() {
            return GroupCreater;
        }

        public void setGroupCreater(String GroupCreater) {
            this.GroupCreater = GroupCreater;
        }

        public String getGroupCreateDateTime() {
            return GroupCreateDateTime;
        }

        public void setGroupCreateDateTime(String GroupCreateDateTime) {
            this.GroupCreateDateTime = GroupCreateDateTime;
        }

        public String getGroupUpdater() {
            return GroupUpdater;
        }

        public void setGroupUpdater(String GroupUpdater) {
            this.GroupUpdater = GroupUpdater;
        }

        public String getGroupUpdateDateTime() {
            return GroupUpdateDateTime;
        }

        public void setGroupUpdateDateTime(String GroupUpdateDateTime) {
            this.GroupUpdateDateTime = GroupUpdateDateTime;
        }

        public String getGroupIsFunction() {
            return GroupIsFunction;
        }

        public void setGroupIsFunction(String GroupIsFunction) {
            this.GroupIsFunction = GroupIsFunction;
        }

        public String getGroupManageJob() {
            return GroupManageJob;
        }

        public void setGroupManageJob(String GroupManageJob) {
            this.GroupManageJob = GroupManageJob;
        }

        public String getGroupFullName() {
            return GroupFullName;
        }

        public void setGroupFullName(String GroupFullName) {
            this.GroupFullName = GroupFullName;
        }

        public String getGroupDispatchCode() {
            return GroupDispatchCode;
        }

        public void setGroupDispatchCode(String GroupDispatchCode) {
            this.GroupDispatchCode = GroupDispatchCode;
        }

        public String getGroupCreaterName() {
            return GroupCreaterName;
        }

        public void setGroupCreaterName(String GroupCreaterName) {
            this.GroupCreaterName = GroupCreaterName;
        }

        public String getGroupUpdaterName() {
            return GroupUpdaterName;
        }

        public void setGroupUpdaterName(String GroupUpdaterName) {
            this.GroupUpdaterName = GroupUpdaterName;
        }

        public String getGroupViewRightID() {
            return GroupViewRightID;
        }

        public void setGroupViewRightID(String GroupViewRightID) {
            this.GroupViewRightID = GroupViewRightID;
        }

        public String getGroupViewRightName() {
            return GroupViewRightName;
        }

        public void setGroupViewRightName(String GroupViewRightName) {
            this.GroupViewRightName = GroupViewRightName;
        }

        public String getGroupIsVisible() {
            return GroupIsVisible;
        }

        public void setGroupIsVisible(String GroupIsVisible) {
            this.GroupIsVisible = GroupIsVisible;
        }

        public String getGroupFlowPrefix() {
            return GroupFlowPrefix;
        }

        public void setGroupFlowPrefix(String GroupFlowPrefix) {
            this.GroupFlowPrefix = GroupFlowPrefix;
        }

        public String getGroupRelationCompany() {
            return GroupRelationCompany;
        }

        public void setGroupRelationCompany(String GroupRelationCompany) {
            this.GroupRelationCompany = GroupRelationCompany;
        }
    }
}
