# alticcix - Calculadora sequência Alticci

O objetivo desta aplicação é retornar o valor referente ao índice da sequência de Alticci, definida por:

n=0 => a(0) = 0

n=1 => a(1) = 1

n=2 => a(2) = 1

n>2 => a(n) = a(n-3) + a(n-2)

## Requisitos

* Java 17
* Redis

## Como utilizar?

1. clone o projeto para uma pasta local desejada, utilizando o comando:
   ```shell script
    git clone git@github.com:csrafael/alticcix.git
    ``` 
2. Execute o banco de dados Redis para funcionar como cache. 
   - Sugestão: rodar com docker com o seguinte comando
   ```shell script
   docker run -d --name redis-stack-server -p 6379:6379 redis/redis-stack-server:latest
   ``` 
3. execute a aplicação através do comando:
```shell script
./gradlew quarkusDev
```

