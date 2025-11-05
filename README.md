# MBT Study

Este repositório contém um estudo-prático de Model-Based Testing (MBT) aplicado a dois aplicativos de exemplo:

- filemanager
- gallery

O objetivo é demonstrar como modelar cenários de teste com GraphWalker, gerar código e integrar testes automatizados Java/Maven para mais de uma aplicação no mesmo projeto.

## Estrutura do repositório

Principais pastas e arquivos:

- `src/main/java` — código fonte (drivers, models, page objects)
	- `com.filemanager` — código relacionado ao app File Manager
	- `com.gallery` — código relacionado ao app Gallery
- `src/main/resources/models` — modelos JSON usados pelos testes (ex.: `modelo-file-manager1.json`, `modelo-gallery1.json`)
- `generated-sources/graphwalker` — código Java gerado pelos modelos GraphWalker
- `pom.xml` — configuração do Maven

## Tecnologias

- Java (JDK 11+ recomendado)
- Maven
- GraphWalker
- Appium

## Pré-requisitos

1. Java JDK (11 ou superior)
2. Maven (3.x)
3. Appium

Verifique as versões instaladas:

```powershell
java -version
mvn -v
```

## Executando os testes

Antes de executar os testes é necessário seguir os seguintes passos para configuração:

1. Clone o repositório:
   ```bash
   git clone [URL do repositório]
   ```

2. Verificar dados do dispositivo (físico ou emulado):
   ```bash
   adb devices

3. Edite as variáveis do dispositivo em `DriverRunner.java`:
   - `appPath`: Diretório do repositório clonado
   - `deviceName`: Nome do dispositivo
   - `deviceUdid`: UDID do dispositivo
   - `deviceOSVersion`: Versão do Android

4. Instale o apk disponível em `src/main/resources` no seu dispositivo:
   - Necessário habilitar instalação de fontes desconhecidas

5. No caso do app Gallery, faça o download do zip disponível em resources, pois os testes são feitos apenas nas pastas deste zip para que não cause problemas em outros diretórios do aparelho e arquivos pessoais.

6. Limpe o cache do maven:
   ```bash
   mvn clean
   ```

7. Inicie o servidor Appium em um terminal separado:
   ```bash
   appium
   ```

8. Execute os testes:

```powershell
mvn graphwalker:test
```

Também é possível executar diretamente a main pela interface da sua IDE.

## Modelos e código gerado

- Modelos JSON: `src/main/resources/models`

Para visualizar os modelos, faça o download dos arquivos e abra pelo GraphWalkerStudio. 