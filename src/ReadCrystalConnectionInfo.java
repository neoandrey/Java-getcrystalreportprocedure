//Crystal Java Reporting Component (JRC) imports.

import com.crystaldecisions.reports.sdk.*;
import com.crystaldecisions.sdk.occa.report.data.*;
import com.crystaldecisions.sdk.occa.report.lib.*;

import java.io.*;

public class ReadCrystalConnectionInfo {
     static FileWriter fileWriter = null;
	static PrintWriter printWriter =null;

	public static void main(String[] args) {

		try {
		    fileWriter =  new FileWriter("template_procedure_map.txt");
			printWriter = new PrintWriter(fileWriter);
			File sourceFolder = new File(args[0]);
			File[] reportFiles= sourceFolder.listFiles();

			for(int i=0; i<reportFiles.length; i++){

			ReportClientDocument reportClientDoc = new ReportClientDocument();
			reportClientDoc.open(reportFiles[i].getAbsolutePath(), 0);

			for (int j = 0; j < reportClientDoc.getDatabaseController().getDatabase().getTables().size(); j++)
				{
				
		try {
				   
					Table table = (Table)reportClientDoc.getDatabaseController().getDatabase().getTables().getTable(j);
					   printWriter.println(reportFiles[i].getName()+"\t"+table.getName());
					System.out.println(reportFiles[i].getName()+"\t"+table.getName());
					System.out.println(reportFiles[i].getName()+"\t"+table.getName());
					}catch(Exception e){
			  e.printStackTrace();
			}
				}
			}
			printWriter.close();
			fileWriter.close();
			}catch(Exception e){
			
			  e.printStackTrace();
			}
			}
			}