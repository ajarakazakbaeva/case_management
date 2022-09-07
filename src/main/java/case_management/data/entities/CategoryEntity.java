package case_management.data.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "category", schema = "inc_db", catalog = "postgres")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Basic
    @CreationTimestamp
    @Column(name = "rec_time")
    private Timestamp recTime;

    @UpdateTimestamp
    @Column(name = "update_time")
    private Timestamp updateTime;

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @Basic
    @Column(name = "is_deleted")
    private Boolean isDeleted;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "parent_id")
    private String parentId;


}
