package com.airbnb.airbnbapp.entity;

import com.airbnb.airbnbapp.enums.BookingStatus;
import com.airbnb.airbnbapp.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.awt.print.Book;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Integer age;

//    @ManyToMany(mappedBy = "guest")
//    private Set<Booking> bookings;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdDt;

    @UpdateTimestamp
    private LocalDateTime updatedDt;

}

