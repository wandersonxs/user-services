package com.auctionall.userservices.infrastructure.adapter.out.persistence.model;

import com.auctionall.userservices.application.domain.User;
import com.auctionall.userservices.application.domain.shared.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "users")
public class UserData {

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

    public static UserData fromDomain(User user) {
        var entity = new UserData();
        entity.setId(Objects.isNull(user.id()) ? UUID.randomUUID() : user.id());
        entity.setName(user.name());
        entity.setDateOfBirth(user.dateOfBirth());
        entity.setStatus(user.status().name());
        return entity;
    }

}
