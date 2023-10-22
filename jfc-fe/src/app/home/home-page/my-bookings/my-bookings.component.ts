
import { Component, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';

export interface FlightData {
  flightNumber: string;
  ticketNumber: string;
  departureIATA: string;
  departureTime: string;
  arrivalIATA: string;
  arrivalTime: string;
}

@Component({
  selector: 'app-my-bookings',
  templateUrl: './my-bookings.component.html',
  styleUrls: ['./my-bookings.component.scss'],

})
export class MyBookingsComponent {

  displayedColumns: string[] = [
    'flightNumber',
    'ticketNumber',
    'departureIATA',
    'departureTime',
    'arrivalIATA',
    'arrivalTime',
  ];
  
  dataSource: MatTableDataSource<FlightData>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor() {
    const data: FlightData[] = [
      {
        flightNumber: 'AF234',
        ticketNumber: 'T54321',
        departureIATA: 'CDG',
        departureTime: '9:30 AM',
        arrivalIATA: 'AMS',
        arrivalTime: '11:00 AM',
      },
      {
        flightNumber: 'TK567',
        ticketNumber: 'T12345',
        departureIATA: 'IST',
        departureTime: '12:00 PM',
        arrivalIATA: 'BCN',
        arrivalTime: '2:00 PM',
      },
      {
        flightNumber: 'EI890',
        ticketNumber: 'T67890',
        departureIATA: 'DUB',
        departureTime: '10:15 AM',
        arrivalIATA: 'SVO',
        arrivalTime: '3:30 PM',
      },
      {
        flightNumber: 'AA123',
        ticketNumber: 'T12345',
        departureIATA: 'JFK',
        departureTime: '10:00 AM',
        arrivalIATA: 'LAX',
        arrivalTime: '1:00 PM',
      },
      {
        flightNumber: 'DL456',
        ticketNumber: 'T67890',
        departureIATA: 'ATL',
        departureTime: '9:30 AM',
        arrivalIATA: 'ORD',
        arrivalTime: '11:30 AM',
      },
      {
        flightNumber: 'LH101',
        ticketNumber: 'T98765',
        departureIATA: 'FRA',
        departureTime: '8:00 AM',
        arrivalIATA: 'CDG',
        arrivalTime: '9:30 AM',
      },
      {
        flightNumber: 'BA456',
        ticketNumber: 'T54321',
        departureIATA: 'LHR',
        departureTime: '11:30 AM',
        arrivalIATA: 'MAD',
        arrivalTime: '1:30 PM',
      },
      {
        flightNumber: 'AZ789',
        ticketNumber: 'T24680',
        departureIATA: 'FCO',
        departureTime: '7:45 AM',
        arrivalIATA: 'ATH',
        arrivalTime: '10:15 AM',
      },
    ];

    this.dataSource = new MatTableDataSource(data);
  }

  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }
}