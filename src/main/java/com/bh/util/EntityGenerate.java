package com.bh.util;


import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceUtils;

import com.shuyin.framework.database.entity.generate.ColumnInfo;
import com.shuyin.framework.database.entity.generate.TableInfo;



public class EntityGenerate   {
	private final StringBuilder sb = new StringBuilder();
	private int depth = 0;
	String[] tables ={"base_user"};
	private static final String entityPackage = "com.bh.entity";
	private static final String daoPackage = "com.bh.dao";
	private static final String daoImplPackage = "com.bh.daoImpl";
	private static final String servicePackage = "com.bh.service";
	private static final String serviceImplPackage = "com.bh.serviceImpl";
	Map<String,String> table_comment = new HashMap<String,String>();
	
	Connection getConnection() throws SQLException{
		ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath*:/spring-config/applicationContext.xml");
		  return DataSourceUtils.getConnection((DataSource)ctx.getBean("dataSource"));
	}
	List<TableInfo> getTableInfos() throws SQLException {
		List<TableInfo> tableInfoList = new ArrayList<TableInfo>();
		Connection conn = getConnection();
		DatabaseMetaData dmd = conn.getMetaData();
		for(String table :tables){
			TableInfo tableInfo = new TableInfo();
			tableInfo.setTableName(table);
			tableInfo.setClassName(getClassName(table));
			tableInfo.setComment(table_comment.get(table));
			List<ColumnInfo> columnInfoList = new ArrayList<ColumnInfo>();
			ResultSet tmpRs = conn.createStatement().executeQuery("select * from " + tableInfo.getTableName() + " limit 1,1");
			ResultSetMetaData rsmd = tmpRs.getMetaData();
			int cSize = rsmd.getColumnCount();
			for (int i = 1; i <= cSize; i++) {
				ColumnInfo columnInfo = new ColumnInfo();
				columnInfo.setColumnName(rsmd.getColumnName(i));
				columnInfo.setFieldName(getFieldName(rsmd.getColumnName(i)));
				columnInfo.setJavaType(rsmd.getColumnClassName(i));
				columnInfo.setDataType(rsmd.getColumnTypeName(i));
				ResultSet columnsRs = dmd.getColumns("", "%", tableInfo.getTableName(), rsmd.getColumnName(i));
				ResultSet  rs=dmd.getColumns(conn.getCatalog(), "%", tableInfo.getTableName(), "%ID");
				String  primaryKey="";
			    if(rs.next()){
			    	primaryKey=rs.getString("COLUMN_NAME");
			    }
				while (columnsRs.next()) {
					columnInfo.setComment(columnsRs.getString("REMARKS"));
					break;
				}
				if(primaryKey.equals(columnInfo.getColumnName())){
					columnInfo.setIsPrimaryKey(true);
				}else {
					columnInfo.setIsPrimaryKey(false);
				}
				columnsRs.close();
				columnInfoList.add(columnInfo);
			}
			tmpRs.close();
			tableInfo.setColumnInfoList(columnInfoList);
			tableInfoList.add(tableInfo);
		}
		return tableInfoList;
	}
	private String getClassName(String tableName) {
		StringBuilder sb = new StringBuilder();
		char[] tmpChars = tableName.toLowerCase().toCharArray();
		for (int i = 0; i < tmpChars.length; i++) {
			if (i == 0) {
				sb.append(toUpper(tmpChars[i]));
				continue;
			}
			if (tmpChars[i] == '_') {
				if (i + 1 < tmpChars.length) {
					tmpChars[i + 1] = toUpper(tmpChars[i + 1]);
				}
				continue;
			}
			sb.append(tmpChars[i]);
		}
		return sb.toString();
	}
	
	protected char toUpper(char ch) {
		if (ch >= 97 && ch <= 122) {
			ch += 'Z';
			ch -= 'z';
		}
		return ch;
	}
	private String toFirstBig(String text) {
		char[] tmp = text.toCharArray();
		tmp[0] = toUpper(tmp[0]);
		return new String(tmp);
	}
	public void createEntity(String path,String packageName) throws Exception {
		init();
		File f = new File(path+packageName.replaceAll(".", "/"));
		f.mkdirs();
		List<TableInfo> tables = getTableInfos();
		for (int i = 0; i < tables.size(); i++) {
			TableInfo ti = tables.get(i);
			initTableInfo(ti);
			addLine("package ",packageName,";");
			rn();
			addLine("import java.io.Serializable;");
			// initImports(ti);
			rn();
			addLine("import com.shuyin.framework.beans.AbstractEntity;");
			addLine("import com.shuyin.framework.beans.Entity;");
			addLine("import com.shuyin.framework.beans.PrimaryKey;");
			addLine("import com.shuyin.framework.beans.Table;");
			addLine("/**");
			addLine(" * ", ti.getTableName());
			addLine(" * ", ti.getComment());
			addLine(" * @author EntityGenerateTool");
			addLine(" */");
			addLine("@Table(tableName=\"",ti.getTableName(),"\")");
			addLine("public class ", ti.getClassName(), " extends AbstractEntity implements Cloneable{");
			rope();
			for (int c = 0; c < ti.getColumnInfoList().size(); c++) {
				ColumnInfo ci = ti.getColumnInfoList().get(c);
				addLine("/** ", ci.getColumnName(), " ", ci.getDataType(), " */");
				if(ci.getIsPrimaryKey()){
					addLine("@PrimaryKey(primaryKeyName = \"", ci.getColumnName(), "\")");
					addLine("@Entity(columnName = \"", ci.getColumnName(), "\")");
				}else {
					addLine("@Entity(columnName = \"", ci.getColumnName(), "\")");
				}
				
				addLine("protected ", ci.getJavaType(), " ", ci.getFieldName(), ";//", ci.getComment());
			}
			rn();
			for (int c = 0; c < ti.getColumnInfoList().size(); c++) {
				ColumnInfo ci = ti.getColumnInfoList().get(c);
				addLine("/**");
				addLine(" * @Title: ", ci.getColumnName());
				addLine(" * @Description: ", ci.getComment());
				addLine(" * @return ", ci.getJavaType());
				addLine(" */");
				addLine("public ", ci.getJavaType(), " get", toFirstBig(ci.getFieldName()), "() {");
				rope();
				addLine("return ", ci.getFieldName(), ";");
				shift();
				addLine("}");
				rn();
				addLine("/**");
				addLine(" * @Title: ", ci.getColumnName());
				addLine(" * @Description: ", ci.getComment());
				addLine(" * @param ", ci.getJavaType());
				addLine(" */");
				addLine("public void set", toFirstBig(ci.getFieldName()), "(", ci.getJavaType(), " ", ci.getFieldName(), ") {");
				rope();
				addLine("this.", ci.getFieldName(), " = ", ci.getFieldName(), ";");
				shift();
				addLine("}");
			}
			rn();
			addLine("/**");
			addLine(" * @Title: 克隆");
			addLine(" * @Description: JAVA对象的克隆");
			addLine(" * @param com.hfjy.base.entity.", ti.getClassName());
			addLine(" */");
			addLine("@Override");
			addLine("protected ", ti.getClassName(), " clone() throws CloneNotSupportedException {");
			rope();
			addLine("return (", ti.getClassName(), ")super.clone();");
			shift();
			addLine("}");
			shift();
			addLine("}");
			FileOutputStream fos = new FileOutputStream(path + packageName.replaceAll("\\.", "/")+"/"+ti.getClassName() + ".java");
			fos.write(getClassText().getBytes("UTF-8"));
			fos.close();
		}
	}
	
	public void createDao(String path,String packageName) throws Exception {

		File f = new File(path+packageName.replaceAll("\\.", "/")+"/");
		f.mkdirs();
		
		for(String table :tables){
			sb.delete(0, sb.length());
			String tableName = getClassName(table);
			addLine("package ",packageName,";");
			rn();
			addLine("import "+entityPackage+"."+tableName+";");
			rn();
			addLine("public interface "+tableName+"Dao{");
			rn();
			addLine("}");
			FileOutputStream fos = new FileOutputStream(path +packageName.replaceAll("\\.", "/")+"/"+ tableName+"Dao" + ".java");
			fos.write(getClassText().getBytes("UTF-8"));
			fos.close();
		}
		
	}
	public void createDaoImpl(String path,String packageName) throws Exception {
			
			File f = new File(path+packageName.replaceAll("\\.", "/")+"/");
			f.mkdirs();
			for(String table :tables){
				sb.delete(0, sb.length());
				String tableName = getClassName(table);
				addLine("package ",packageName,";");
				rn();
				addLine("import "+entityPackage+"."+tableName+";");
				addLine("import "+daoPackage+"."+tableName+"Dao"+";");
				addLine("import com.shuyin.framework.database.dao.BaseDao;");
				addLine("import org.springframework.stereotype.Repository;");
				rn();
				addLine("@Repository(\""+tableName+"Dao\")");
				addLine("public class "+tableName+"DaoImpl extends BaseDao<"+tableName+"> implements "+tableName+"Dao{");
				rn();
				rn();
				rn();
				rope();
				shift();
				addLine("}");
				FileOutputStream fos = new FileOutputStream(path +packageName.replaceAll("\\.", "/")+"/"+ tableName+"DaoImpl" + ".java");
				fos.write(getClassText().getBytes("UTF-8"));
				fos.close();
			}
		}
	private String getPrimary(String tableName){
		Connection conn = null;
		Statement stmt  = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select COLUMN_KEY,COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS where table_name='"+tableName+"' AND COLUMN_KEY='PRI' " );
		    if(rs != null && rs.next()) {
		        String id = rs.getString(2);
		        if(id!=null && id.trim().length()>0){
		        	return id;
		        }
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			 try {
				stmt.close();
				//DatabaseTools.destroyDBSession();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "id";
	}
	public void createService(String path,String packageName) throws Exception {
		File f = new File(path+packageName.replaceAll("\\.", "/")+"/");
		f.mkdirs();
		for(String table :tables){
			sb.delete(0, sb.length());
			String tableName = getClassName(table);
			addLine("package ",packageName,";");
			rn();
			addLine("public interface "+tableName+"Service {");
			rn();
			addLine("}");
			FileOutputStream fos = new FileOutputStream(path +packageName.replaceAll("\\.", "/")+"/"+ tableName+"Service" + ".java");
			fos.write(getClassText().getBytes("UTF-8"));
			fos.close();
		}
	}
	
	public void createServiceImpl(String path,String packageName) throws Exception {
		File f = new File(path+packageName.replaceAll("\\.", "/")+"/");
		f.mkdirs();
		for(String table :tables){
			sb.delete(0, sb.length());
			String tableName = getClassName(table);
			addLine("package ",packageName,";");
			rn();
			addLine("import " +daoPackage+"."+tableName+"Dao"+";");
			addLine("import " +servicePackage+"."+tableName+"Service"+";");
			addLine("import org.springframework.beans.factory.annotation.Autowired;");
			addLine("import org.springframework.beans.factory.annotation.Qualifier;");
			addLine("import org.springframework.stereotype.Service;");
			rn();
			addLine("@Service(value=\""+tableName+"Service\")");
			addLine("public class "+tableName+"ServiceImpl  implements "+tableName+"Service{");
			rope();
			addLine("@Autowired");
			addLine("@Qualifier(\""+tableName+"Dao\")");
			addLine("private "+tableName+"Dao "+(tableName.substring(0,1).toLowerCase() + tableName.substring(1, tableName.length()))+"Dao;");
			rn();
			shift();
			addLine("}");
			FileOutputStream fos = new FileOutputStream(path +packageName.replaceAll("\\.", "/")+"/"+ tableName+"ServiceImpl" + ".java");
			fos.write(getClassText().getBytes("UTF-8"));
			fos.close();
			
		}
	}
	private void addLine(String... text) {
		if (text != null && text.length > 0) {
			for (int i = 0; i < depth; i++) {
				sb.append("\t");
			}
			for (int i = 0; i < text.length; i++) {
				sb.append(text[i]);
			}
			sb.append("\r\n");
		}

	}


	private void rn() {
		sb.append("\r\n");
	}

	private void rope() {
		depth++;
	}

	private void shift() {
		depth--;
	}

	private String getClassText() {
		return sb.toString();
	}

	private void initTableInfo(TableInfo ti) {
		sb.delete(0, sb.length());
		for (int i = 0; i < ti.getColumnInfoList().size(); i++) {
			if (ti.getColumnInfoList().get(i).getJavaType().equals(Timestamp.class.getName())) {
				ti.getColumnInfoList().get(i).setJavaType(Date.class.getName());
			} else if (ti.getColumnInfoList().get(i).getJavaType().equals(java.sql.Date.class.getName())) {
				ti.getColumnInfoList().get(i).setJavaType(Date.class.getName());
			}
		}
	}
	
	public void  init() {
		Connection conn = null;
		Statement stmt  = null;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			for(String table :tables){
				ResultSet rs = stmt.executeQuery("SHOW CREATE TABLE " + table);
			    if(rs != null && rs.next()) {
			        String create = rs.getString(2);
			        String comment = parse(create);
			        table_comment.put(table,comment);
			    }
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			 try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public  String parse(String all) {
        String comment = null;
        int index = all.indexOf("COMMENT='");
        if(index < 0) {
                return "";
        }
        comment = all.substring(index+9);
        comment = comment.substring(0,comment.length() - 1);
        return comment;
    }
	
	private String getFieldName(String columnName) {
		StringBuilder sb = new StringBuilder();
		char[] tmpChars = columnName.toLowerCase().toCharArray();
		for (int i = 0; i < tmpChars.length; i++) {
			if (tmpChars[i] == '_') {
				if (i + 1 < tmpChars.length) {
					tmpChars[i + 1] = toUpper(tmpChars[i + 1]);
				}
				continue;
			}
			sb.append(tmpChars[i]);
		}
		return sb.toString();
	}

	public static void main(String[] args) throws Exception {
		EntityGenerate egt = new EntityGenerate();
		String path = EntityGenerate.class.getClassLoader().getResource("").getPath();
		path = path.substring(0, path.indexOf("Consoles"));
		path = path + "Consoles/src/main/java/";
		egt.createEntity(path,entityPackage);
		/*egt.createDao(path, daoPackage);
		egt.createDaoImpl(path, daoImplPackage);
		egt.createService(path, servicePackage);
		egt.createServiceImpl(path, serviceImplPackage);*/
	}
}
