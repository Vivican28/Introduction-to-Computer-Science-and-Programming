
Algoritmo AdivinaONo
	Escribir "Estic pensant en un nombre entre 0 i 50"
	NombreSecret <- azar(51)
	NombreDeIntents <- n
	Repetir 
		Escribir "Quin nombre és?"
		Leer Nombre
		Si NombreSecret = Nombre Entonces
			Escribir "Has encertat! El nombree secret és ", NombreSecret
		SiNo
			Si Nombre > NombreSecret  Y NombreDeIntents < 3 Entonces
				Escribir "No has encertat. El nombre a endevinar és menor"
				NombreDeIntents<-n+1
			SiNo
				Escribir "No has encertat. El nombre a endevinar és major"
				NombreDeIntents<-n+1
			Fin Si 
		Fin Si
	Hasta Que NombreDeIntents=3
	
FinAlgoritmo
