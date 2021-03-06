package ru.otus.rehearsal_base.rehearsal_service.domain.room;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "room_status")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RoomStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "description")
    private String description;

    public static RoomStatus active() {
        return new RoomStatus("active");
    }

    public RoomStatus(String id) {
        this.id = id;
    }
}
