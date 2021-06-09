package auth.model;

public class Snippet {
	DROP TABLE CHAT;
	
	CREATE TABLE CHAT (
	  chatID INT PRIMARY KEY AUTO_INCREMENT,
	  fromID VARCHAR(20),
	  toID VARCHAR(20),
	  chatContent VARCHAR(100),
	  chatTime DATETIME,
	  chatRead INT
	);
	
	CREATE TABLE BOARD (
	  userID VARCHAR(20),
	  boardID INT PRIMARY KEY,
	  boardTitle VARCHAR(50),
	  boardContent VARCHAR(2048),
	  boardDate DATETIME,
	  boardHit INT,
	  boardFile VARCHAR(100),
	  boardRealFile VARCHAR(100),
	  boardGroup INT,
	  boardSequence INT,
	  boardLevel INT
	);
}

