use redo_eksamen_db;

insert into discipline (name, result_type)
values
    ('Long Jump', 'Distance'),
    ('100 meter', 'Time'),
    ('Swimming', 'Time'),
    ('Shooting Range', 'Points');


insert into participant (name, gender, age, club)
values
    ('Peter', 'Male', 25, 'Aarhus Swimmers'),
    ('Thyra', 'Male', 99, 'Hjørring Swimmers'),
    ('Mogens', 'Male', 19, 'CPH Swimmers'),
    ('Ulla', 'Male', 61, 'Aarhus Shooters');

insert into result (date, result_value)
values
    ('2021-06-01', 7.5),
    ('2021-06-01', 8.5),
    ('2021-06-01', 9.5),
    ('2021-06-01', 10.5);

insert into participant_disciplines (participant_id, disciplines_id)
values
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4);