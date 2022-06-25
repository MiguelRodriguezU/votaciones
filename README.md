# ApiVotaciones
Api para registrar candidatos y votar por ellos.

# EndPoints
(GET) Consultar los candidatos 
- http://localhost:8081/v1/candidates

(POST) Registrar un candidato
- http://localhost:8081/v1/candidates
Body:
{
	"names": "Rafael",
	"surnames": "Lopez",
	"birthdate": "01/01/1962",
	"proposal": "Sin Impuestos para todos",
	"politicalParty": "Renovación Popular"
}

(GET) Consultar votos de un candidato
- http://localhost:8081/v1/candidates/1/votes

(POST) Registrar voto para un candidato
- http://localhost:8081/v1/candidates/1/votes


