package Lab3;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import Lab3.User;
import java.util.List;
public class SqlUtil {
    /**
     * 根据传入的参数返回查询语句
     * @param user
     * @return 返回查询语句
     */
    String query(User user) {
    	StringBuilder Builder = new StringBuilder();
    	Class c = user.getClass();
    	//判断表是否为注解
    	if(!c.isAnnotationPresent(Table.class)) {
    		return null;
    	}
    	Table t = (Table)c.getAnnotation(Table.class);
    	
    	//得到表名称
    	String tName = t.value();
    	Builder.append("SELECT * FROM `").append(tName).append("` WHERE "); 
    	
    	//利用映射得到类的变量
    	Field[] Array = c.getDeclaredFields();  
    	int temp = 1;
    	for (Field field : Array) {    
    		 //判断是否包含Column类型的注解 
            if(!field.isAnnotationPresent(Column.class)){  
                continue;  
            }  
            //得到类型上面注解的值  
            Column column = field.getAnnotation(Column.class);  
            String columnName = column.value();    
            //拿到字段名 
            String filedName = field.getName();  
            //获取相应字段的getXXX()方法   
            String getMethodName = "get" + filedName.substring(0, 1).toUpperCase()  
                    + filedName.substring(1);  
    	    Object fieldValue = null;//不同属性的值 
            try {  
                Method getMethod = c.getMethod(getMethodName);  
                fieldValue = getMethod.invoke(user);  
            } catch (Exception e) {  
               e.printStackTrace();  
            }   
            if(fieldValue==null || (fieldValue instanceof Integer && (Integer)fieldValue==0)){  
               continue;  
            } 
           if(temp!=1) {
        	Builder.append(" and ") ;
            if(fieldValue instanceof String) {
        	   Builder.append("`").append(filedName).append("` ").append("LIKE").append(" `").append((String)fieldValue).append("` ");  
            }
            else {
        	   Builder.append(filedName).append(" = ").append(fieldValue).append(" ");  
            }
          }
           else {
        	  
               if(fieldValue instanceof String) {
           	   Builder.append("`").append(filedName).append("` ").append("LIKE").append(" `").append((String)fieldValue).append("` ");  
               }
               else {
           	   Builder.append(filedName).append(" = ").append(fieldValue).append(" ");  
               } 
           }
           temp++;
        }    
    	return Builder.toString();
    } 
//
    /**
     * 根据传入的参数返回插入语句
     * @param user
     * @return 返回插入语句
     */
    String insert(User user) {
    	StringBuilder Builder = new StringBuilder();
    	Class c = user.getClass();
    	//判断表是否为注解
    	if(!c.isAnnotationPresent(Table.class)) {
    		return null;
    	}
    	Table t = (Table)c.getAnnotation(Table.class);
    	
    	//得到表名称
    	String tName = t.value();
    	Builder.append("INSERT INTO `").append(tName).append("`("); 
    	//利用映射得到类的变量
    	Field[] Array = c.getDeclaredFields();  
    	
    	//打印表的属性字段
    	for (Field field : Array) {    
    		 //判断是否包含Column类型的注解 
            if(!field.isAnnotationPresent(Column.class)){  
                continue;  
            }  
            //得到类型上面注解的值  
            Column column = field.getAnnotation(Column.class);  
            String columnName = column.value();    
            //拿到字段名 
            String filedName = field.getName();  
            //获取相应字段的getXXX()方法   
            String getMethodName = "get" + filedName.substring(0, 1).toUpperCase()  
                    + filedName.substring(1);  
    	    Object fieldValue = null;//不同属性的值 
            try {  
                Method getMethod = c.getMethod(getMethodName);  
                fieldValue = getMethod.invoke(user);  
            } catch (Exception e) {  
               e.printStackTrace();  
            }   
            if(fieldValue==null || (fieldValue instanceof Integer && (Integer)fieldValue==0)){  
               continue;  
            } 
            //不打印id
            if(filedName != "id") {
         	   Builder.append("`").append(filedName).append("`,");  
             }
        }
    	
    	//删除多余的，
    	Builder.deleteCharAt(Builder.length()-1);
    	Builder.append(")VLAUES(");  
    	
    	//打印表的属性对应的值
    	Field[] Array2 = c.getDeclaredFields();  
    	for (Field field : Array2) {    
    		 //判断是否包含Column类型的注解 
            if(!field.isAnnotationPresent(Column.class)){  
                continue;  
            }  
            //得到类型上面注解的值  
            Column column = field.getAnnotation(Column.class);  
            String columnName = column.value();    
            //拿到字段名 
            String filedName = field.getName();  
            //获取相应字段的getXXX()方法   
            String getMethodName = "get" + filedName.substring(0, 1).toUpperCase()  
                    + filedName.substring(1);  
    	    Object fieldValue = null;//不同属性的值 
            try {  
                Method getMethod = c.getMethod(getMethodName);  
                fieldValue = getMethod.invoke(user);  
            } catch (Exception e) {  
               e.printStackTrace();  
            }   
            if(fieldValue==null || (fieldValue instanceof Integer && (Integer)fieldValue==0)){  
               continue;  
            } 
            if(filedName != "id") {
               if(fieldValue instanceof String) {
         	       Builder.append("`").append(fieldValue).append("`,");  
               }
               else {
            	   Builder.append(fieldValue).append(",");
               }
             }
        }
    	Builder.deleteCharAt(Builder.length()-1);
    	Builder.append(")");
    	return Builder.toString();
    }
//
    /**
     * 根据传入的参数返回插入语句
     * @param users
     * @return 返回插入语句
     */
    String insert(List<User> users) {
    	StringBuilder Builder = new StringBuilder();
    	Class c = users.get(0).getClass();
    	//判断表是否为注解
    	if(!c.isAnnotationPresent(Table.class)) {
    		return null;
    	}
    	Table t = (Table)c.getAnnotation(Table.class);
    	
    	//得到表名称
    	String tName = t.value();
    	Builder.append("INSERT INTO `").append(tName).append("`("); 
    	//利用映射得到类的变量
    	Field[] Array = c.getDeclaredFields();  
    	
    	//打印表的属性字段
    	for (Field field : Array) {    
    		 //判断是否包含Column类型的注解 
            if(!field.isAnnotationPresent(Column.class)){  
                continue;  
            }  
            //得到类型上面注解的值  
            Column column = field.getAnnotation(Column.class);  
            String columnName = column.value();    
            //拿到字段名 
            String filedName = field.getName();  
            //获取相应字段的getXXX()方法   
            String getMethodName = "get" + filedName.substring(0, 1).toUpperCase()  
                    + filedName.substring(1);  
    	    Object fieldValue = null;//不同属性的值 
            try {  
                Method getMethod = c.getMethod(getMethodName);  
                fieldValue = getMethod.invoke(users.get(0));  
            } catch (Exception e) {  
               e.printStackTrace();  
            }   
            if(fieldValue==null || (fieldValue instanceof Integer && (Integer)fieldValue==0)){  
               continue;  
            } 
            //不打印id
            if(filedName != "id") {
         	   Builder.append("`").append(filedName).append("`,");  
             }
        }
    	
    	//删除多余的，
    	Builder.deleteCharAt(Builder.length()-1);
    	Builder.append(")VLAUES(");
    	//遍历列表
    	for(int i=0;i<users.size();i++) {
    		Field[] Array2 = c.getDeclaredFields();  
        	for (Field field : Array2) {    
        		 //判断是否包含Column类型的注解 
                if(!field.isAnnotationPresent(Column.class)){  
                    continue;  
                }  
                //得到类型上面注解的值  
                Column column = field.getAnnotation(Column.class);  
                String columnName = column.value();    
                //拿到字段名 
                String filedName = field.getName();  
                //获取相应字段的getXXX()方法   
                String getMethodName = "get" + filedName.substring(0, 1).toUpperCase()  
                        + filedName.substring(1);  
        	    Object fieldValue = null;//不同属性的值 
                try {  
                    Method getMethod = c.getMethod(getMethodName);  
                    fieldValue = getMethod.invoke(users.get(i));  
                } catch (Exception e) {  
                   e.printStackTrace();  
                }   
                if(fieldValue==null || (fieldValue instanceof Integer && (Integer)fieldValue==0)){  
                   continue;  
                } 
                if(filedName != "id") {
                   if(fieldValue instanceof String) {
             	       Builder.append("`").append(fieldValue).append("`,");  
                   }
                   else {
                	   Builder.append(fieldValue).append(",");
                   }
                 }
            }
        	Builder.deleteCharAt(Builder.length()-1);
        	Builder.append("),(");
    	}
    	Builder.deleteCharAt(Builder.length()-1);
    	Builder.deleteCharAt(Builder.length()-1);
    	return Builder.toString();
    	
    }

    /**
     * 根据传入的参数返回删除语句（删除id为user.id的记录）
     * @param user
     * @return 返回删除语句
     */
    String delete(User user) {
        StringBuilder Builder = new StringBuilder();
	    Class c = user.getClass();
	    //判断表是否为注解
	    if(!c.isAnnotationPresent(Table.class)) {
		    return null;
	    }
	    Table t = (Table)c.getAnnotation(Table.class);
	
	    //得到表名称
	    String tName = t.value();
	    Builder.append("DELETE FROM `").append(tName).append("` WHERE `id` = ").append(user.getId());
	    return Builder.toString(); 
    };
    /**
     * 根据传入的参数返回更新语句（将id为user.id的记录的其它字段更新成user中的对应值）
     * @param user
     * @return 返回更新语句
     */
    String update(User user) {
    	StringBuilder Builder = new StringBuilder();
    	Class c = user.getClass();
    	//判断表是否为注解
    	if(!c.isAnnotationPresent(Table.class)) {
    		return null;
    	}
    	Table t = (Table)c.getAnnotation(Table.class);
    	
    	//得到表名称
    	String tName = t.value();
    	Builder.append("UPDATE `").append(tName).append("` SET"); 
    	//利用映射得到类的变量
    	Field[] Array = c.getDeclaredFields();  
    	for (Field field : Array) {    
    		 //判断是否包含Column类型的注解 
            if(!field.isAnnotationPresent(Column.class)){  
                continue;  
            }  
            //得到类型上面注解的值  
            Column column = field.getAnnotation(Column.class);  
            String columnName = column.value();    
            //拿到字段名 
            String filedName = field.getName();  
            //获取相应字段的getXXX()方法   
            String getMethodName = "get" + filedName.substring(0, 1).toUpperCase()  
                    + filedName.substring(1);  
    	    Object fieldValue = null;//不同属性的值 
            try {  
                Method getMethod = c.getMethod(getMethodName);  
                fieldValue = getMethod.invoke(user);  
            } catch (Exception e) {  
               e.printStackTrace();  
            }   
            if(fieldValue==null || (fieldValue instanceof Integer && (Integer)fieldValue==0)){  
               continue;  
            } 
          //更新过的属性
            if(filedName != "id") {
        	   Builder.append("`").append(filedName).append("` ").append("=").append(" `").append((String)fieldValue).append("` ");  
            }
           
        }   
    	//更新的id
    	Builder.append("WHERE `id` = " ).append(user.getId());  
    	return Builder.toString();
        
    }
//   
//
}