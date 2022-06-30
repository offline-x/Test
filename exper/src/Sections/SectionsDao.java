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
                // ͨ���ֶμ���
                int  section_id=rs.getInt("section_id");
                String section_name=rs.getString("section_name");
                int  manager_id= rs.getInt("manager_id");
                int place_id=rs.getInt("place_id");
                // �������
                System.out.println(section_id+"\t"+ section_name+"\t" + manager_id +"\t"+ place_id);
            }
            // ��ɺ�ر�
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
          // ��ɺ�ر�
          if(rs>0){
              System.out.println("�޸ĳɹ���");
          }else { System.out.println("�޸�ʧ�ܣ�");}
          pst.close();
      } catch (SQLException e) {
          e.printStackTrace();
      }
  }
}
