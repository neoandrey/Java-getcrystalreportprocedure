//Crystal Java Reporting Component (JRC) imports.

import com.crystaldecisions.reports.sdk.*;
import com.crystaldecisions.sdk.occa.report.data.*;
import com.crystaldecisions.sdk.occa.report.lib.*;

import java.io.*;

public class WriteCrystalConnectionInfo {
    static FileWriter fileWriter = null;
	static PrintWriter printWriter =null;
	static ReportClientDocument reportClientDoc = null;

	public static void main(String[] args) {

		try {
		    fileWriter =  new FileWriter("template_procedure_map.txt");
			printWriter = new PrintWriter(fileWriter);
			File sourceFolder = new File(args[0]);
			File[] reportFiles= sourceFolder.listFiles();
			ConnectionInfo crConnectionInfo = new ConnectionInfo();

			for(int i=0; i<reportFiles.length; i++){
			reportClientDoc = new ReportClientDocument();
				reportClientDoc.open(reportFiles[i].getAbsolutePath(), 1);
				crConnectionInfo.ServerName = "YOUR SERVER NAME";
				crConnectionInfo.DatabaseName = "YOUR DATABASE NAME";
				crConnectionInfo.UserID = "YOUR DATABASE USERNAME";
				crConnectionInfo.Password = "YOUR DATABASE PASSWORD";
			Table[]	CrTables = reportClientDoc.Database.Tables;
				for(i =0; i< CrTables.length; ++i){
			     Table CrTable=CrTables[i];
				   crtableLogoninfo = CrTable.LogOnInfo;
				   crtableLogoninfo.ConnectionInfo = crConnectionInfo;
				   CrTable.ApplyLogOnInfo(crtableLogoninfo);
				}
			}
			}catch(Exception e){
			
			  e.printStackTrace();
			}
			}
			}