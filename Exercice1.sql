//1.1
	//1.2 : show tables;
	//1.3 : describ t_articles;
	//1.5 : UPDATE t_articles SET UnitaryPrice = 67 WHERE idArticle = 1;
	//1.6 :  DELETE FROM t_articles WHERE idArticle = 12;
	//1.7 : SELECT * FROM t_articles WHERE unitaryPrice > 100;
	//1.8 : SELECT * FROM t_articles WHERE unitaryPrice between 50 and 150;
	//1.9 : SELECT * FROM t_articles ORDER BY unitaryPrice ASC;
	//1.10 : SELECT Description FROM t_articles;
	//(UPDATE T_articles set idcategory = 1 where idArticle = 12;)
	//1.13 :  SELECT IdArticle, t_categories.Description, 
				//brand, unitaryPrice, t_categories.catName 
					//FROM t_articles, t_categories 
					//WHERE T_articles.idcategory = t_categories.idcategory; 