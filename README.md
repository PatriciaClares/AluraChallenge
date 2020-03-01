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
        - Request payload
        ```json
            {
                "email": "exemplo@exemplo.com",
                "senha": 123123
            }
        ```
        - ` status 200 `

    - **palpita em um jogo**
        - ` POST ` ` /usuario/palpite/jogo `
        - Request payload
        ```json
        {
            "nomeTimeCasa": "abc",
            "nomeTimeVisitante": "bca",
            "rodada": 1,
            "placar": {
                "golsTimeCasa": 123,
                "golsTimeVisitante": 123
            }
        }
        ```
        - ` Status 200 `   
    
    - **pega pontuação feita pelo palpite do usuário**
        - ` GET ` ` /usuario/palpite/pontuacao?email=exemplo@exemplo.com `
        - Response payload
        ```json
            {
                "pontuação": 10
            }
        ```
        - ` Status 200 `

- time
    - **cria time**
        - ` POST ` `/time/`
        - Request payload
        ```json
            {
                "nome": "abc",
                "dataFundacao0": "2020-12-31"
            }
        ```
        - ` Status 201 `

- campeonato
    - **cria campeonato**
        - ` POST ` ` /campeonato/ `
        - Request payload
        ```json
            {
                "nome": "abc",
                "dataInicio": "01/01/2020",
                "quantidadeTimesParticipantes": 5,
                "times": ["abc", "bca"] 
            }
        ```
        - *adicionar um time ao campeonato é opcional*
        - ` Status 201 `

- bolao
    - **cria bolão**
        - ` POST ` ` /bolao/ `
        - Request Payload
        ```json
            {
                "campeonatoNome": "abc",
                "emails": ["exemplo@exemplo.com", "exemplo1@exemplo.com"]
            }
        ```
        - ` Status 201 `
    
    - **aceita convite do bolão**
        - ` PUT ` ` /bolao/participantes `
        - Request payload 
        ```json
            {
                "participantes": ["exemplo@exemplo.com", "exemplo1@exemplo.com"]
            }
        ```
        - ` Status 200 `
    
- jogo
    - **cria jogo em um campeonato**
        - `POST` `/jogo/`
        - Request payload
        ```json
            {
                "timeCasa": "abc",
                "timeVisitante": "bca",
                "horaComeco": "13:00",
                "campeonatoNome": "abcd",
                "rodada": 1
            }
        ```
        - ` Status 201 `

    - **processa pontuação do palpite de uma rodada**
        - ` GET ` ` /jogo/placar/pontuacao `
        - Response payload
        ```json
            {
                "jogo": {
                    "horaComeco": "13:00",
                    "timeCasa": "abc",
                    "timeVisitante": "bca",
                    "placar": {
                        "golsTimeCasa": 123,
                        "golsTimeVisitante": 123
                    },
                    "rodada": 1
                },
                "placar": {
                    "golsTimeCasa": 123,
                    "golsTimeVisitante": 123
                },
                "pontuacao": 10
            }
        ```
        - ` Status 200 `
    
