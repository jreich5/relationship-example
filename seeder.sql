use pets_db;


# seed pet_details
insert into pet_details (is_sterile, personality_description, weight_in_ounces) values
(true, 'A good dog', 45.23),
(false, 'A good cat', 15.23),
(true, 'A good fish', 5.23),
(false, 'A good alligator', 95.23),
(false, 'A good snake', 195.23);

# seed pets
insert into pets (name, dob, species, pet_details_id) values
('Sparky', '2010-01-01', 'Dog', 1),
('Sparkles', '2010-01-01', 'Cat', 2),
('Spark', '2010-01-01', 'Fish', 3),
('Parky', '2010-01-01', 'Alligator', 4),
('Bubbles', '2010-01-01', 'Snake', 5);


