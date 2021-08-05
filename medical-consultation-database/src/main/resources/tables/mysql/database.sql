CREATE TABLE veterinarians(
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(255) NOT NULL,
    phone VARCHAR(20),
    email VARCHAR(255),
    created_at DATETIME NOT NULL,
	updated_at DATETIME DEFAULT NULL,
	deleted_at DATETIME DEFAULT NULL,
	is_active BOOLEAN DEFAULT FALSE
);

CREATE TABLE animals(
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(255) NOT NULL,
    species VARCHAR(255) NOT NULL,
    breed VARCHAR(255) NOT NULL,
    birth_date DATE NOT NULL,
    created_at DATETIME NOT NULL,
	updated_at DATETIME DEFAULT NULL,
	deleted_at DATETIME DEFAULT NULL,
	is_active BOOLEAN DEFAULT FALSE
);

CREATE TABLE tutors(
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    animals_id INTEGER NOT NULL,
    name VARCHAR(255) NOT NULL,
    phone VARCHAR(20),
    email VARCHAR(255),
    created_at DATETIME NOT NULL,
	updated_at DATETIME DEFAULT NULL,
	deleted_at DATETIME DEFAULT NULL,
	is_active BOOLEAN DEFAULT FALSE,
	FOREIGN KEY (animals_id) REFERENCES animals(id)
);

CREATE TABLE consults(
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    animals_id INTEGER NOT NULL,
    veterinarians_id INTEGER NOT NULL,
    status VARCHAR(20) NOT NULL,
    consult_date DATETIME NOT NULL,
    created_at DATETIME NOT NULL,
	FOREIGN KEY (animals_id) REFERENCES animals(id),
	FOREIGN KEY (veterinarians_id) REFERENCES veterinarians(id)
);