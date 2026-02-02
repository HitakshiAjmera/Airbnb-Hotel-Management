package com.airbnb.airbnbapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name ="hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) //it will give error if name is null from db level only
    private String name;

    private String city;

//    @Column(columnDefinition = "Text[]") //it will store the url of image
//    private String[] photos;
//
//    @Column(columnDefinition = "Text[]")
//    private String amenities;
    @ElementCollection
    @CollectionTable(name = "hotel_photos", joinColumns = @JoinColumn(name = "hotel_id"))
    @Column(name = "photo_url")
    private List<String> photos;

    @ElementCollection
    @CollectionTable(name = "hotel_amenities", joinColumns = @JoinColumn(name = "hotel_id"))
    @Column(name = "amenity")
    private List<String> amenities;

    @CreationTimestamp
    private LocalDateTime createdDt;

    @UpdateTimestamp
    private LocalDateTime updatedDt;

    @Embedded
    private HotelContactInfo contactInfo;

    @Column(nullable = false)
    private Boolean active;

    @ManyToOne
    private User owner ;
    @OneToMany(mappedBy = "hotel" , fetch = FetchType.LAZY)
    private List<Room> rooms;


}
