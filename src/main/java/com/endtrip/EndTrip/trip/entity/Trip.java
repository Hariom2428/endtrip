package com.endtrip.EndTrip.trip.entity;

import com.endtrip.EndTrip.common.entity.BaseEntity;
import com.endtrip.EndTrip.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "trips")
public class Trip extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false ,length = 200)
    private String title;

    @Column(nullable = false ,length = 200)
    private  String destination;

    @Column(length = 200)
    private  String description;

    @Column(name="start_date",nullable = false)
    private LocalDate startDate;

    @Column(name ="end_Date",nullable = false)
    private LocalDate endDate;

    @Column(precision = 12,scale = 2)
    private BigDecimal budget;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length = 20)
    private  TripStatus status =TripStatus.PLANED;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "owner_id",nullable = false)
    private User owner;


}
