SELECT UserReportGroup0.USER_REP_GROUP_ID fld_0_0 , ((case when UserReportGroup0.forwarded_dt>AbstractReport3.updated_dt then UserReportGroup0.forwarded_dt else AbstractReport3.updated_dt end)) fld_0_1 , Folder1.USER_FOLDER_ID fld_1_0 , ReportGroup2.REP_GROUP_ID fld_2_0 , ReportGroup2.GROUP_TP fld_2_1 , AbstractReport3.REP_ID fld_3_0 , AbstractReport3.REP_TP fld_3_1 , (select upper(     CASE          WHEN (r.rep_tp = 'OR' and r.SAE_AS_FL = 'N' and r.SAE_CS_FL = 'N' )         THEN nvl((select SHORT_TRL from TRANSLATION where topic_id = 5 and lng_cd = upper('EN')          and sub_lng_cd = 'STANDARD' and TRL_ID = r.prd_item_id), r.prd_short_nm)         ELSE CASE              WHEN r.rep_tp = 'IR' and r.SAE_AS_FL = 'N' and r.SAE_CS_FL = 'N'              THEN 'Imported'             ELSE CASE                  WHEN r.rep_tp = 'IR' and r.SAE_AS_FL = 'N' and r.SAE_CS_FL = 'Y'                  THEN 'Custom Search Export'                 ELSE CASE                      WHEN r.rep_tp = 'IR' and r.SAE_AS_FL = 'Y' and r.SAE_CS_FL = 'N'                      THEN 'AutoScreen Export'               ELSE CASE                      WHEN r.REP_SUB_TP = 'CS-HITLIST'  THEN 'Custom Search Hitlist'                     WHEN r.REP_SUB_TP = 'CS-REPORT'   THEN 'Custom Search Report'                     WHEN r.REP_SUB_TP = 'AS-HITLIST'  THEN 'AutoScreen Hitlist'                     WHEN r.REP_SUB_TP = 'AS-REPORT'   THEN 'AutoScreen Report'                     WHEN r.REP_SUB_TP = 'ISS-HITLIST' THEN 'ISS Hitlist'                     WHEN r.REP_SUB_TP = 'ISS-REPORT'  THEN 'ISS Report'                     WHEN r.SAE_CS_FL = 'Y' THEN 'Custom search Analysis'                     WHEN r.SAE_AS_FL = 'Y' THEN 'Autoscreen Analysis'               END              END              END          END      END)   from report r where r.rep_id = AbstractReport3.rep_id) fld_3_2 , AbstractReport3.PRD_SHORT_NM fld_3_3 , AbstractReport3.UPDATED_DT fld_3_4 , AbstractReport3.INBOX_DLV_DT fld_3_5 , AbstractReport3.LATEST_VERSION_FL fld_3_6 , AbstractReport3.CANCELLED_FL fld_3_7 , AbstractReport3.TRM_SEARCHED fld_3_8 FROM USER_REP_GROUP UserReportGroup0 INNER JOIN USER_FOLDER Folder1 ON UserReportGroup0.USER_FOLDER_ID = Folder1.USER_FOLDER_ID LEFT OUTER JOIN REP_GROUP ReportGroup2 ON UserReportGroup0.REP_GROUP_ID = ReportGroup2.REP_GROUP_ID LEFT OUTER JOIN REPORT AbstractReport3 ON ReportGroup2.REP_ID = AbstractReport3.REP_ID WHERE ( (Folder1.USER_FOLDER_ID = ? ) AND ( ( ( ( upper((select upper(     CASE          WHEN (r.rep_tp = 'OR' and r.SAE_AS_FL = 'N' and r.SAE_CS_FL = 'N' )         THEN nvl((select SHORT_TRL from TRANSLATION where topic_id = 5 and lng_cd = upper('EN')          and sub_lng_cd = 'STANDARD' and TRL_ID = r.prd_item_id), r.prd_short_nm)         ELSE CASE              WHEN r.rep_tp = 'IR' and r.SAE_AS_FL = 'N' and r.SAE_CS_FL = 'N'              THEN 'Imported'             ELSE CASE                  WHEN r.rep_tp = 'IR' and r.SAE_AS_FL = 'N' and r.SAE_CS_FL = 'Y'                  THEN 'Custom Search Export'                 ELSE CASE                      WHEN r.rep_tp = 'IR' and r.SAE_AS_FL = 'Y' and r.SAE_CS_FL = 'N'                      THEN 'AutoScreen Export'               ELSE CASE                      WHEN r.REP_SUB_TP = 'CS-HITLIST'  THEN 'Custom Search Hitlist'                     WHEN r.REP_SUB_TP = 'CS-REPORT'   THEN 'Custom Search Report'                     WHEN r.REP_SUB_TP = 'AS-HITLIST'  THEN 'AutoScreen Hitlist'                     WHEN r.REP_SUB_TP = 'AS-REPORT'   THEN 'AutoScreen Report'                     WHEN r.REP_SUB_TP = 'ISS-HITLIST' THEN 'ISS Hitlist'                     WHEN r.REP_SUB_TP = 'ISS-REPORT'  THEN 'ISS Report'                     WHEN r.SAE_CS_FL = 'Y' THEN 'Custom search Analysis'                     WHEN r.SAE_AS_FL = 'Y' THEN 'Autoscreen Analysis'               END              END              END          END      END)   from report r where r.rep_id = AbstractReport3.rep_id)) like ?)  ) AND ( ( (( AbstractReport3.UPDATED_DT >=  TO_DATE (?,'YYYY/MM/DD HH24:MI:SS' )  )  ) AND ( ( (( (( (ReportGroup2.GROUP_TP = ? ) OR ( ( (ReportGroup2.GROUP_TP = ? ) OR ( ( (ReportGroup2.GROUP_TP = ? ) OR ( ( (ReportGroup2.GROUP_TP = ? ) OR ( ReportGroup2.GROUP_TP = ? ) ) ) ) ) ) ) ) ) AND ( ( (( AbstractReport3.INBOX_DLV_DT <=  TO_DATE (?,'YYYY/MM/DD HH24:MI:SS' )  )  ) AND ( ( (AbstractReport3.LATEST_VERSION_FL = 'Y' ) AND ( AbstractReport3.CANCELLED_FL = 'N' ) ) ) ) ) ) ) OR ( AbstractReport3.REP_TP in ('IR','SR') ) ) ) ) ) ) ) ) ORDER BY  fld_0_1 desc, nls_upper(AbstractReport3.TRM_SEARCHED) asc, PARAMS: [708690, %WORD%, 2012/03/02 14:31:29, STANDARD_SEARCH, AUTOMATED_DEVICE, AUTOMATED_WORD, SAEGIS_CS, SAEGIS_AS, 2015/03/02 14:31:29]