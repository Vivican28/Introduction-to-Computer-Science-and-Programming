
Algoritmo AdivinaONo
	Escribir "Estic pensant en un nombre entre 0 i 50"
	NombreSecret <- azar(51)
	NombreDeIntents <- n
	Repetir 
		Escribir "Quin nombre �s?"
		Leer Nombre
		Si NombreSecret = Nombre Entonces
			Escribir "Has encertat! El nombree secret �s ", NombreSecret
		SiNo
			Si Nombre > NombreSecret  Y NombreDeIntents < 3 Entonces
				Escribir "No has encertat. El nombre a endevinar �s menor"
				NombreDeIntents<-n+1
			SiNo
				Escribir "No has encertat. El nombre a endevinar �s major"
				NombreDeIntents<-n+1
			Fin Si 
		Fin Si
	Hasta Que NombreDeIntents=3
	
FinAlgoritmo
