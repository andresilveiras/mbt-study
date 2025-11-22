# MBT Study

[🇧🇷 Português](#português) | [🇺🇸 English](#english)

## Português

### Visão Geral
Este repositório contém um estudo-prático de Model-Based Testing (MBT) aplicado a três aplicativos de exemplo: notepad, gallery e filemanager. O objetivo é demonstrar como modelar cenários de teste com GraphWalker, gerar código e integrar testes automatizados Java/Maven com o framework Appium para mais de uma aplicação no mesmo projeto.

### Stack Tecnológica
- **Framework de Automação**: Appium v2.12.0
- **Ferramenta MBT**: GraphWalker v4.3.3
- **Linguagem**: Java (JDK 21.0.5)
- **Gerenciador de Dependências**: Maven v3.9.8
- **Compatibilidade**: Windows, Linux e macOS
- **Plataforma de Teste**: Android

### Pré-requisitos

#### Ferramentas de Desenvolvimento
1. Git
2. IDE de sua preferência
   - Para Visual Studio Code: Instalar "Extension Pack for Java" da Microsoft
3. Java JDK 21.0.5
   - [Download e instruções de instalação](https://www.oracle.com/java/technologies/downloads/)
   - **Importante**: Versão 21 recomendada devido a problemas de compatibilidade com versões posteriores
4. Maven
   - [Guia de instalação](https://maven.apache.org/install.html)
   - Configurar após a instalação do Java

5. Android Studio e ADB
   - [Download e configuração do ADB](https://developer.android.com/tools/adb)
6. Appium
   - Requer Node.js
   - [Guia de instalação](https://appium.io/docs/en/2.2/quickstart/install/)
7. Driver UIAutomator2
   - [Instruções de instalação](https://appium.io/docs/en/2.2/quickstart/uiauto2-driver/)
8. Appium Inspector (opcional)
   - [Download](https://github.com/appium/appium-inspector)
9. GraphWalker
   - [Instalação e documentação](https://graphwalker.github.io/)

### Configuração do Dispositivo

#### Para Dispositivo Físico
1. Ativar modo desenvolvedor
2. Habilitar depuração USB
3. Conectar via USB com compartilhamento de mídia
4. Configurar permissões do Appium (disponível ao conectar o servidor Appium com o dispositivo pela primeira vez)


#### Para Emulador
- Configurar dispositivo virtual via Android Studio


### Configuração do Projeto

1. Clonar o repositório:
   ```bash
   git clone [URL do repositório]
   ```

2. Verificar dados do dispositivo (físico ou emulado):
   ```bash
   adb devices -l
   ```

3. Configurar variáveis do dispositivo em `DriverRunner.java`:
   - `appPath`: Diretório do repositório clonado
   - `deviceName`: Nome do dispositivo (model)
   - `deviceUdid`: UDID do dispositivo
   - `deviceOSVersion`: Versão do Android

4. Instalar o APK disponível em `src/main/resources` no seu dispositivo:
   - Necessário habilitar instalação de fontes desconhecidas

5. No caso do app Gallery, faça o download do zip disponível em resources e extraia para o diretório de imagens do seu dispositivo. Os testes são feitos apenas nas pastas deste zip para que não cause problemas em outros diretórios do aparelho e arquivos pessoais.

### Execução dos Testes

1. Limpar o cache do Maven:
   ```bash
   mvn clean
   ```

2. Iniciar servidor Appium em um terminal separado:
   ```bash
   appium
   ```

3. Para dispositivos físicos:
   - Recomendado: Usar [Vysor](https://www.vysor.io/) para espelhamento

4. Executar testes:
   ```powershell
   Execute o arquivo Main.java
   ```

### Estrutura do Repositório

```
mbt-study/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       ├── Main.java                    # Ponto de entrada principal dos testes
│   │   │       ├── filemanager/                 # Módulo File Manager
│   │   │       │   ├── DriverRunner.java        # Configuração do driver Appium
│   │   │       │   ├── FileManagerMain.java     # Classe principal de execução
│   │   │       │   ├── impl/                     # Implementações das ações do modelo
│   │   │       │   ├── model/                    # Modelo GraphWalker
│   │   │       │   └── po/                       # Page Objects (BasePage, NewFilePage, etc.)
│   │   │       ├── gallery/                      # Módulo Gallery
│   │   │       │   ├── DriverRunner.java
│   │   │       │   ├── impl/                     # Implementações (MainFlow, VideoPlayer, etc.)
│   │   │       │   ├── model/                    # Modelos GraphWalker
│   │   │       │   └── po/                       # Page Objects
│   │   │       └── notepad/                      # Módulo Notepad
│   │   │           ├── DriverRunner.java
│   │   │           ├── NotepadMain.java
│   │   │           ├── impl/                     # Implementações
│   │   │           ├── model/                    # Modelo GraphWalker
│   │   │           └── po/                       # Page Objects
│   │   └── resources/
│   │       ├── models/                           # Modelos JSON do GraphWalker
│   │       │   ├── modelo-file-manager1.json
│   │       │   ├── modelo-gallery1.json
│   │       │   └── NotepadTestModel_v1.json
│   │       ├── *.apk                             # APKs dos aplicativos sob teste
│   │       └── Gallery-Media.zip                 # Arquivos de teste para Gallery
|   └──
├── pom.xml                                       # Configuração Maven e dependências
└── README.md                                     # Documentação do projeto
```

#### Descrição dos Componentes

**Código Fonte (`src/main/java/com/`)**
- Cada módulo (`filemanager`, `gallery`, `notepad`) segue a mesma estrutura:
  - **`DriverRunner.java`**: Configuração e inicialização do driver Appium
  - **`*Main.java`**: Classe principal que executa os testes do módulo
  - **`impl/`**: Implementações das ações definidas nos modelos GraphWalker
  - **`model/`**: Interfaces dos modelos GraphWalker
  - **`po/`**: Page Objects que encapsulam os elementos e ações da UI

**Recursos (`src/main/resources/`)**
- **`models/`**: Modelos JSON do GraphWalker que definem os grafos de teste
- **APKs**: Aplicativos Android utilizados nos testes
- **Arquivos de teste**: Recursos adicionais necessários para execução (ex.: imagens para Gallery)

### Modelos e Código Gerado

Os modelos JSON estão disponíveis em `src/main/resources/models`.

Para visualizar os modelos, faça o download dos arquivos e abra pelo [GraphWalkerStudio](https://graphwalker.github.io/#download).

### Créditos

- **FarmerBB**: [Notepad](https://github.com/farmerbb/Notepad) — Por disponibilizar o app Notepad utilizado no estudo
- **Fossify**: [FossifyOrg](https://github.com/FossifyOrg) — Por disponibilizar os apps Gallery e File Manager utilizados no estudo
- **GraphWalker**: [GraphWalker](https://github.com/GraphWalker) — Ferramenta MBT utilizada
- **Appium**: [Appium](https://github.com/appium) — Framework de automação utilizado

## English

### Overview
This repository contains a practical study of Model-Based Testing (MBT) applied to three example applications: notepad, gallery, and filemanager. The objective is to demonstrate how to model test scenarios with GraphWalker, generate code, and integrate automated Java/Maven tests for multiple applications in the same project.

### Technology Stack
- **Automation Framework**: Appium v2.12.0
- **MBT Tool**: GraphWalker v4.3.3
- **Language**: Java (JDK 21.0.5)
- **Dependency Manager**: Maven v3.9.8
- **Compatibility**: Windows, Linux, and macOS
- **Testing Platform**: Android

### Prerequisites

#### Development Tools
1. Git
2. IDE of your choice
   - For Visual Studio Code: Install Microsoft's "Extension Pack for Java"
3. Java JDK 21.0.5
   - [Download and installation instructions](https://www.oracle.com/java/technologies/downloads/)
   - **Important**: Version 21 recommended due to compatibility issues with newer versions
4. Maven
   - [Installation guide](https://maven.apache.org/install.html)
   - Configure after Java installation
5. Android Studio and ADB
   - [ADB download and setup](https://developer.android.com/tools/adb)
6. Appium
   - Requires Node.js
   - [Installation guide](https://appium.io/docs/en/2.2/quickstart/install/)
7. UIAutomator2 Driver
   - [Installation instructions](https://appium.io/docs/en/2.2/quickstart/uiauto2-driver/)
8. Appium Inspector (optional)
   - [Download](https://github.com/appium/appium-inspector)
9. GraphWalker
   - [Installation and documentation](https://graphwalker.github.io/)

### Device Setup

#### For Physical Device
1. Enable developer mode
2. Enable USB debugging
3. Connect via USB with media sharing enabled
4. Configure Appium permissions (available when connecting the device to Appium Server for the first time)

#### For Emulator
- Set up virtual device via Android Studio

### Project Setup

1. Clone the repository:
   ```bash
   git clone [repository URL]
   ```

2. Verify device data (physical or emulated):
   ```bash
   adb devices
   ```

3. Configure device variables in `DriverRunner.java`:
   - `appPath`: Cloned repository directory
   - `deviceName`: Device name
   - `deviceUdid`: Device UDID
   - `deviceOSVersion`: Android version

4. Install the APK available in `src/main/resources` on your device:
   - Must enable installation from unknown sources

5. For the Gallery app, download the zip available in resources and extract it to your device's images directory. Tests are performed only on folders from this zip to avoid issues with other device directories and personal files.

### Running Tests

1. Clean Maven cache:
   ```bash
   mvn clean
   ```

2. Start Appium server in a separate terminal:
   ```bash
   appium
   ```

3. For physical devices:
   - Recommended: Use [Vysor](https://www.vysor.io/) for screen mirroring

4. Execute tests:
   ```powershell
   Execute the Main.java file
   ```

### Repository Structure

```
mbt-study/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       ├── Main.java                    # Main entry point for tests
│   │   │       ├── filemanager/                 # File Manager module
│   │   │       │   ├── DriverRunner.java        # Appium driver configuration
│   │   │       │   ├── FileManagerMain.java     # Main execution class
│   │   │       │   ├── impl/                     # Model action implementations
│   │   │       │   ├── model/                    # GraphWalker model
│   │   │       │   └── po/                       # Page Objects (BasePage, NewFilePage, etc.)
│   │   │       ├── gallery/                      # Gallery module
│   │   │       │   ├── DriverRunner.java
│   │   │       │   ├── impl/                     # Implementations (MainFlow, VideoPlayer, etc.)
│   │   │       │   ├── model/                    # GraphWalker models
│   │   │       │   └── po/                       # Page Objects
│   │   │       └── notepad/                      # Notepad module
│   │   │           ├── DriverRunner.java
│   │   │           ├── NotepadMain.java
│   │   │           ├── impl/                     # Implementations
│   │   │           ├── model/                    # GraphWalker model
│   │   │           └── po/                       # Page Objects
│   │   └── resources/
│   │       ├── models/                           # GraphWalker JSON models
│   │       │   ├── modelo-file-manager1.json
│   │       │   ├── modelo-gallery1.json
│   │       │   └── NotepadTestModel_v1.json
│   │       ├── *.apk                             # APKs of applications under test
│   │       └── Gallery-Media.zip                 # Test files for Gallery
|   └──
├── pom.xml                                       # Maven configuration and dependencies
└── README.md                                     # Project documentation
```

#### Component Description

**Source Code (`src/main/java/com/`)**
- Each module (`filemanager`, `gallery`, `notepad`) follows the same structure:
  - **`DriverRunner.java`**: Appium driver configuration and initialization
  - **`*Main.java`**: Main class that executes the module tests
  - **`impl/`**: Implementations of actions defined in GraphWalker models
  - **`model/`**: GraphWalker model interfaces
  - **`po/`**: Page Objects that encapsulate UI elements and actions

**Resources (`src/main/resources/`)**
- **`models/`**: GraphWalker JSON models that define test graphs
- **APKs**: Android applications used in tests
- **Test files**: Additional resources needed for execution (e.g., images for Gallery)

### Models and Generated Code

JSON models are available in `src/main/resources/models`.

To view the models, download the files and open them in [GraphWalkerStudio](https://graphwalker.github.io/#download).

### Credits

- **FarmerBB**: [Notepad](https://github.com/farmerbb/Notepad) — For providing the Notepad app used in this study
- **Fossify**: [FossifyOrg](https://github.com/FossifyOrg) — For providing the Gallery and File Manager apps used in this study
- **GraphWalker**: [GraphWalker](https://github.com/GraphWalker) — MBT tool used
- **Appium**: [Appium](https://github.com/appium) — Automation framework used
