# AluraChallenge

Esse projeto é um pequeno sistema via API Web com [Spring Boot](https://spring.io/projects/spring-boot) e [Hibernate](https://hibernate.org/) para manipulação de bolões para jogos.

## Documentação de uso da API

Os endpoints estão separados de acordo com os dominios da applicação 

### Endpoints

Segue o seguinte formarto de requisições e respostas:

- Dominio
    - *descricao*
        - `verbo` `rota`
        - ` payload da requisição no formato application/json `
        - ` payload da resposta no formato application/json `
        - ` status de retorno `

---

- usuario
    - **cria usuário**
        - ` POST ` ` /usuario `
        - Payload request
        ```json
            {
                "email": "exemplo@exemplo.com",
                "senha": 123123
            }
        ```
        - ` status 200 `

    - **palpita em um jogo**
        - ` POST ` ` /usuario/palpite/jogo `
        - Payload request
        ```json
        {
            "jogo": {
                "horaComeco": "13:00",
                "timeCasa": {
                    "nome": "abc",
                    "dataFundacao": "01/01/2020"
                },
                "timeVisitante": {
                    "nome": "bca",
                    "dataFundacao": "01/01/2020"
                },
                "placar": {
                    "golsTimeCasa": 1,
                    "golsTimeVisitante": 2
                },
                "rodada": 1
            },
            "placar": {
                "golsTimeCasa": 123,
                "golsTimeVisitante": 123
            }
        }
        ```
        - ` Status 200 `   
    
    - **pega pontuação feita pelo palpite do usuário**
        - ` GET ` ` /usuario/palpite/pontuacao `
        - Payload request
        ```json
            {
                "email": "exemplo@exemplo.com"
            }
        ```
        - Payload response
        ```json
            {
                "pontuação": 10
            }
        ```
        - ` Status 200 `

    
    
    
