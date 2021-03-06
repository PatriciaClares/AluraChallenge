# AluraChallenge

Esse projeto é um pequeno sistema via API Web com [Spring Boot](https://spring.io/projects/spring-boot) e [Hibernate](https://hibernate.org/) para manipulação de bolões para jogos.

## Documentação de uso da API

Os endpoints estão separados de acordo com os dominios da applicação 

### Endpoints

Disclaimers:

- Todas as rotas esperam o prefixo ``` /api/ ``` nas rotas;
- Muitas rotas pedem que tenha o email de de um usuario válido para simular autenticação (Sim, pretendo adicionar JWT); 

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
        - ` POST ` ` /usuario?bolaoId=3`
        - query string opcional
        - Request payload
        ```json
            {
                "email": "exemplo@exemplo.com",
                "senha": 123123
            }
        ```
        - ` status 200 `
        
- palpite
    - **palpita em um jogo**
        - ` POST ` ` /palpite/jogo `
        - Request payload
        ```json
            {
                "emailusuario": "example@example.com",
                "jogoDTO": {
                    "timeCasa": "abc",
                    "timeVisitante": "bca",
                    "horaComeco": "2020-12-31 12:00",
                    "campeonatoNome": "bcd",
                    "rodada": 1
                },
                "placar": {
                    "golsTimeCasa": 123,
                    "golsTimeVisitante": 123,
                    "timeVencedor": "bca"
                }
            }
        ```
        - ` Status 200 `   
        
    - **pega pontuação feita pelo palpite do usuário**
        - ` GET ` ` /palpite/pontuacao?email=exemplo@exemplo.com `
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
                "dataFundacao": "2020-12-31",
                "campeonatoNome": "abc" 
            }
        ```
        - *adicionar um campeonato é opcional*
        - ` Status 201 `

- campeonato
    - **cria campeonato**
        - ` POST ` ` /campeonato/ `
        - Request payload
        ```json
            {
                "nome": "abc",
                "dataInicio": "2020-12-31",
                "quantidadeTimesParticipantes": 5
            }
        ```
        - ` Status 201 `

- bolao
    - **cria bolão**
        - ` POST ` ` /bolao/ `
        - Request Payload
        ```json
            {
                "usuarioEmail": "rleao5344@gmail.com",
                "campeonatoNome": "abaaaasc",
                "emailParticipantes": ["rleao53@gmail.com", "rleao5344@gmail.com"],
                "conviteLink": "https://www.convite.com/bolao/participantes?email=rleao534433@gmail.com&bolaoId=1",
                "dataExpiracaoConvite": "2020-12-31 12:00"
            }
        ```
        - ` Status 201 `
    
    - **aceita convite do bolão**
        - ` PUT ` ` /bolao/participantes?email=rleao534433@gmail.com&bolaoId=1 `
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
                "rodada": 1,
                "placar":  {
                    "golsTimeCasa": 123,
                    "golsTimeVisitante": 123
                }
            }
        ```
        - placar deve ser usado apenas quando um jogo acaba e deve ser registrado
        - ` Status 201 `
