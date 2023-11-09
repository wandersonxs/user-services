package com.auctionall.userservices.infrastructure.adapter.out.persistence.entity;

import com.auctionall.userservices.application.domain.User;
import com.auctionall.userservices.application.domain.shared.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

//@Getter
//@Table("users")
//@EqualsAndHashCode
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder(toBuilder = true)
@Entity
@Setter
@Getter
@Table(name = "users")
public class UserEntity {

    @Id
    private UUID id;

    private String name;

    private LocalDate dateOfBirth;

    private String status;


    public User toDomain() {
        return new User(
                id,
                name,
                dateOfBirth,
                Status.valueOf(status)
        );
    }

    public static UserEntity fromDomain(User user) {
        var entity = new UserEntity();
        entity.setId(Objects.isNull(user.id()) ? UUID.randomUUID() : user.id());
        entity.setName(user.name());
        entity.setDateOfBirth(user.dateOfBirth());
        entity.setStatus(user.status().name());
        return entity;
    }

}
