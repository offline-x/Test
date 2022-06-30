package Sections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SectionsDao {
    PreparedStatement pst = null;
    public void getAll(Connection conn){
        try {
            pst = conn.prepareStatement("SELECT * FROM sections order by section_id");
            ResultSet rs = pst.executeQuery();
            System.out.println("section_id\tsection_name\tmanager_id\tplace_id");
            while(rs.next()){
                // 通过字段检索
                int  section_id=rs.getInt("section_id");
                String section_name=rs.getString("section_name");
                int  manager_id= rs.getInt("manager_id");
                int place_id=rs.getInt("place_id");
                // 输出数据
                System.out.println(section_id+"\t"+ section_name+"\t" + manager_id +"\t"+ place_id);
            }
            // 完成后关闭
            rs.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
  public void modify(Connection conn,int section_id,String section_name){
      try {
          pst = conn.prepareStatement("update sections set section_name=? where section_id=?");
          pst.setString(1,section_name);
          pst.setInt(2,section_id);
          int rs = pst.executeUpdate();
          // 完成后关闭
          if(rs>0){
              System.out.println("修改成功！");
          }else { System.out.println("修改失败！");}
          pst.close();
      } catch (SQLException e) {
          e.printStackTrace();
      }
  }
}
