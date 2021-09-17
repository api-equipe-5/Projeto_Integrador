create table springproject.journey(
     id SERIAL not null PRIMARY KEY,
    idDriver integer NOT NULL,
    date TEXT NOT NULL,
    mealTime float not null,
    workingTime float not null,
    restTime float not null,
    observation TEXT not null
);