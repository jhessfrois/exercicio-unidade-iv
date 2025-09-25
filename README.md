<p align="center"> 
  <img alt="Logo Faculdade Unyleya" src="https://portalgraduacao.unyleya.edu.br/b50f33bcb2dd5f603598a7d6dcc4c58c.png" width="200px" />
</p> 

<p align="center">
Exercícios referente à Unidade IV de Programação Orientada à Objetos.
</p>

<p align="center">
  <a href="#-linguagens">Linguagens</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-atividades">Atividades</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-objetivo">Objetivo</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-boas-práticas-aplicadas">Boas Práticas Aplicadas</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-contato">Contato</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-licença">Licença</a>
</p>

<p align="center">
  <img alt="License" src="https://camo.githubusercontent.com/cd878d57e2b361acc4718461dd7a9c2828f3c132dcfb18d363883883a7df60a3/68747470733a2f2f696d672e736869656c64732e696f2f6769746875622f6c6963656e73652f496c65726961796f2f6d61726b646f776e2d6261646765733f7374796c653d666f722d7468652d6261646765">
</p>

<br>

<p align="center">
  <img alt="Preview do projeto desenvolvido." src="https://imgur.com/l9j6wTr.png" width="80%">
</p>

> Exercício realizado no dia 25 de Setembro de 2025

## 🚀 Linguagens

Esse exercício foi realizado com as seguintes linguagens:

- ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)


## 📖 Atividades

1. **Cadastro de veículos:**  
   - Carros, Motos e Caminhões  
   - Atributos específicos por tipo (ex.: número de portas, cilindradas, capacidade de carga)

2. **Listagem de veículos:**  
   - Exibe todos os veículos cadastrados, separados por tipo

3. **Cadastro de clientes:**  
   - Nome, idade, endereço, telefone, email, altura e peso

4. **Venda de veículos:**  
   - Seleção de veículo pelo índice  
   - Registro da venda com data, preço e cálculo de lucro/perda  

5. **Relatório de vendas:**  
   - Lista todas as vendas com informações detalhadas  

6. **Sugestão de veículos por biotipo (IMC):**  
   - Sugere veículos adequados ao biotipo do cliente  

7. **Tratamento de exceções personalizadas:**  
   - `ClienteNaoEncontradoException`  
   - `VeiculoIndisponivelException`

---

## 💻 Objetivo

Este projeto implementa um sistema de **concessionária de veículos** em Java, permitindo cadastrar, listar, vender veículos e clientes, 
além de gerar relatórios de vendas e sugestões de veículos com base no biotipo (IMC) dos clientes.

O sistema suporta os seguintes tipos de veículos:  
- Carro  
- Moto  
- Caminhão

As exceções personalizadas ajudam a controlar erros, como tentativa de vender veículo indisponível ou buscar cliente inexistente.

---

## ✅ Boas Práticas Aplicadas

1. **Organização de pastas:**  
   - Código-fonte (`Concessionaria`) separado das exceções (`Excecoes`) para modularidade.

2. **Encapsulamento:**  
   - Todos os atributos das classes são privados/protected e acessados via getters e setters.

3. **Interface para veículos (`InterfaceVeiculo`):**  
   - Permite adicionar novos tipos de veículos facilmente, seguindo o princípio de **abstração**.

4. **Tratamento de exceções:**  
   - Exceções personalizadas (`ClienteNaoEncontradoException`, `VeiculoIndisponivelException`) garantem que erros sejam tratados de forma clara e controlada.

5. **Reuso de código:**  
   - Métodos genéricos como `sugerirVeiculosPorBiotipo` e `mostrarTodosVeiculos` evitam duplicação de código.

6. **Princípio de responsabilidade única:**  
   - Cada classe tem uma função específica (ex.: `Venda` apenas registra vendas, `Pessoa` apenas armazena dados do cliente).

--- 

## **🤍 Contato**

[<img src='https://img.shields.io/badge/Instagram-E4405F?style=for-the-badge&logo=instagram&logoColor=white' alt='Instagram' height='30'>](https://www.instagram.com/jhessfrois.tech)
[<img src='https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white' alt='Linkedin' height='30'>](https://www.linkedin.com/in/jhessfrois/)
[<img src='https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white' alt='Gmail' height='30'>](jhessfsantos@gmail.com)

## 📝 Licença

Esse projeto está sob a licença MIT.

