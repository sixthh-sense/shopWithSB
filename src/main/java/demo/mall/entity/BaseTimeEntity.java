package demo.mall.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@EntityListeners(value = {AuditingEntityListener.class}) // Auditing을 적용하기 위함
@MappedSuperclass
@Getter
@Setter
public abstract class BaseTimeEntity {

    @CreatedDate // 생성시각(자동저장)
    @Column(updatable = false)
    private LocalDateTime regTime;

    @LastModifiedDate // 최신 변경시각(자동저장)
    private LocalDateTime updateTime;
}
