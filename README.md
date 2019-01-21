# Assignment Java Cast Group
> castgroupassignment1.



Aplicação Restful que expõem três enpoints com a finalidade de comparar dados criptografados em base64.

> castgroupassignment3.



Aplicação Restful que expõem enpoints com a finalidade de listar pessoas, encontrar pessoa pelo id, cadastrar pessoa e remover pessoa.

![](../header.png)


## Pré-Requisitos

```sh
Eclipse IDE
Maven 3.6.0
JDK 8
```


## Exemplo de uso

Os serviços devem ser consumido via aplicação ou Api de teste como Postman ou SoapUi.

http://localhost:8080/rest/pessoa/save
  
  ```
  {
        "name": "Thiago Gitirana",
        "address": 
        {
        	"street": "Rua Teste",
        	"number": 101,
        	"neighborhood": "Teste",
        	"city": "Recife",
        	"state": "Pernambuco"
        },
        "phones": [
            {
                "cellPhone": 99559955,
                "phone": 34466446
            },
            {
                "cellPhone": 99885555,
                "phone": 33225522
            }
        ]
    }
```



## Configuração para Desenvolvimento

```sh
Maven Build
Junit Test
Run Spring Boot App
```

## Meta

Thiago Gitirana

[https://github.com/thiagogitirana/castgroup/](https://github.com/thiagogitirana/castgroup/)
