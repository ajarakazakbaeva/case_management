package case_management.data.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "incidents", schema = "inc_db", catalog = "postgres")
public class IncidentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Basic
    @CreationTimestamp
    @Column(name = "rec_time")
    private Timestamp recTime;
    @Basic
    @UpdateTimestamp
    @Column(name = "update_time")
    private Timestamp updateTime;
    @Basic
    @Column(name = "is_deleted")
    private Boolean isDeleted;
    @Basic
    @Column(name = "type")
    private Integer type;
    @Basic
    @Column(name = "category_id")
    private int categoryId;
    @Basic
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "state_id")
    private Integer stateId;
    @Basic
    @Column(name = "priority")
    private Integer priority;
    @Basic
    @Column(name = "source_user_id")
    private Integer sourceUserId;
    @Basic
    @Column(name = "destination_user_id")
    private Integer destinationUserId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getRecTime() {
        return recTime;
    }

    public void setRecTime(Timestamp recTime) {
        this.recTime = recTime;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getSourceUserId() {
        return sourceUserId;
    }

    public void setSourceUserId(Integer sourceUserId) {
        this.sourceUserId = sourceUserId;
    }

    public Integer getDestinationUserId() {
        return destinationUserId;
    }

    public void setDestinationUserId(Integer destinationUserId) {
        this.destinationUserId = destinationUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IncidentsEntity that = (IncidentsEntity) o;

        if (id != that.id) return false;
        if (categoryId != that.categoryId) return false;
        if (userId != that.userId) return false;
        if (recTime != null ? !recTime.equals(that.recTime) : that.recTime != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (stateId != null ? !stateId.equals(that.stateId) : that.stateId != null) return false;
        if (priority != null ? !priority.equals(that.priority) : that.priority != null) return false;
        if (sourceUserId != null ? !sourceUserId.equals(that.sourceUserId) : that.sourceUserId != null) return false;
        if (destinationUserId != null ? !destinationUserId.equals(that.destinationUserId) : that.destinationUserId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (recTime != null ? recTime.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + categoryId;
        result = 31 * result + userId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (stateId != null ? stateId.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        result = 31 * result + (sourceUserId != null ? sourceUserId.hashCode() : 0);
        result = 31 * result + (destinationUserId != null ? destinationUserId.hashCode() : 0);
        return result;
    }
}
