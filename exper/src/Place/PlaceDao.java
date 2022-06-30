package Place;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaceDao {
    PreparedStatement pst = null;
    public void getAll(Connection conn){
        try {
            pst = conn.prepareStatement("SELECT * FROM places");
            ResultSet rs = pst.executeQuery();
            System.out.println("place_id\tstreet_address\tpostal_code\tcity\tstate_province\tstate_id");
            while(rs.next()) {
                // ͨ���ֶμ���
                int place_id = rs.getInt("place_id");
                String street_address = rs.getString("street_address");
                String postal_code = rs.getString("postal_code");
                String city = rs.getString("city");
                String state_province = rs.getString("state_province");
                String state_id = rs.getString("state_id");
                // �������
                System.out.println(place_id +"\t"+ street_address+"\t"+ postal_code +"\t"+ city+"\t"  + state_province+"\t" + state_id );

            }
            // ��ɺ�ر�
            rs.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   public void add(Connection conn,int place_id, String street_address , String postal_code,String city, String state_province, String state_id){
       try {
           pst = conn.prepareStatement("insert into places values (?,?,?,?,?,?)");
           pst.setInt(1,place_id);
           pst.setString(2,street_address);
           pst.setString(3,postal_code);
           pst.setString(4,city);
           pst.setString(5,state_province);
           pst.setString(6,state_id);
           int rs=pst.executeUpdate();
           // ��ɺ�ر�
           if(rs>0){
               System.out.println("���ӳɹ���");
           }else { System.out.println("����ʧ�ܣ�");}
           // ��ɺ�ر�
           pst.close();
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
}
