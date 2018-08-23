-- ----------------------------------
-- Banco de Dados IEMEV
-- Projeto Final APS 171 - PUC/RJ
-- ----------------------------------

-- ----------------------------------
-- Tabela T_PESSOA
-- ----------------------------------

DROP TABLE IF EXISTS T_PESSOA;
CREATE TABLE IF NOT EXISTS T_PESSOA (
cpf			bigint (11) PRIMARY KEY,
rg			bigint (9) NOT NULL,
nome			text NOT NULL,
endereco		text NOT NULL,
telefoneResidencial	varchar (11) NOT NULL,
celular			decimalvarchar (11) NOT NULL,
dataDeNascimento	date NOT NULL
);

-- ----------------------------------
-- Tabela T_EMPREGADO
-- ----------------------------------

DROP TABLE IF EXISTS T_EMPREGADO;
CREATE TABLE IF NOT EXISTS T_EMPREGADO (
cpfEmpregado		bigint (11) PRIMARY KEY,
idEmpregado		decimal (4) NOT NULL,
dataDeAdmissaoEmpregado	date NOT NULL,
ramal			decimal (4) NOT NULL,
emailEmpregado		text NOT NULL,
senha			decimal (4) NOT NULL,
indicadorNovaSenha	boolean NOT NULL,
tipoEmpregado		text NOT NULL,
idAdministradorDeCadastramento	decimal(4) NOT NULL,
FOREIGN KEY (cpfEmpregado) REFERENCES T_PESSOA (cpf) ON UPDATE CASCADE,
FOREIGN KEY (idAdministradorDeCadastramento) REFERENCES T_EMPREGADO (idEmpregado) ON UPDATE CASCADE
);

-- ----------------------------------
-- Tabela T_VETERINARIO
-- ----------------------------------

DROP TABLE IF EXISTS T_VETERINARIO;
CREATE TABLE IF NOT EXISTS T_VETERINARIO (
cpfUsuario		bigint (11) PRIMARY KEY,
crmv			decimal(8) NOT NULL,
especialidade		text NOT NULL,
FOREIGN KEY (cpfUsuario) REFERENCES T_PESSOA (cpf) ON UPDATE CASCADE
);

-- ----------------------------------
-- Tabela T_ATENDENTE
-- ----------------------------------

DROP TABLE IF EXISTS T_ATENDENTE;
CREATE TABLE IF NOT EXISTS T_ATENDENTE (
cpfUsuario		bigint (11) PRIMARY KEY,
FOREIGN KEY (cpfUsuario) REFERENCES T_PESSOA (cpf) ON UPDATE CASCADE
);

-- ----------------------------------
-- Tabela T_ADMINISTRADOR
-- ----------------------------------

DROP TABLE IF EXISTS T_ADMINISTRADOR;
CREATE TABLE IF NOT EXISTS T_ADMINISTRADOR (
cpfUsuario		bigint (11) PRIMARY KEY,
FOREIGN KEY (cpfUsuario) REFERENCES T_PESSOA (cpf) ON UPDATE CASCADE
);

-- ----------------------------------
-- Tabela T_CLIENTE
-- ----------------------------------

DROP TABLE IF EXISTS T_CLIENTE;
CREATE TABLE IF NOT EXISTS T_CLIENTE (
cpfUsuario		bigint (11) PRIMARY KEY,
emailCliente		text NOT NULL,
idAtendenteDeCadastramento  decimal (4) NOT NULL,
FOREIGN KEY (cpfUsuario) REFERENCES T_PESSOA (cpf) ON UPDATE CASCADE,
FOREIGN KEY (idAtendenteDeCadastramento) REFERENCES T_EMPREGADO (idEmpregado) ON UPDATE CASCADE
);

-- ----------------------------------
-- Tabela T_ANIMAL
-- ----------------------------------

DROP TABLE IF EXISTS T_ANIMAL;
CREATE TABLE IF NOT EXISTS T_ANIMAL (
idAnimal		decimal (4) PRIMARY KEY,
nomeAnimal		text NOT NULL,
sexo			char (1) NOT NULL,
dataDeNascimentoAnimal	date NOT NULL,
especie			text NOT NULL,
porte			text NOT NULL,
raca			text NOT NULL,
pelagem			text NOT NULL,
temperamento		text NOT NULL,
cpfCliente		bigint (11) NOT NULL,
idAtendenteDeCadastramento  decimal (4) NOT NULL,
FOREIGN KEY (cpfCliente) REFERENCES T_PESSOA (cpf) ON UPDATE CASCADE,
FOREIGN KEY (idAtendenteDeCadastramento) REFERENCES T_EMPREGADO (idEmpregado) ON UPDATE CASCADE
);

-- ----------------------------------
-- Tabela T_SERVICO
-- ----------------------------------

DROP TABLE IF EXISTS T_SERVICO;
CREATE TABLE IF NOT EXISTS T_SERVICO (
idServico		decimal (4) PRIMARY KEY,
categoria		text NOT NULL,
nomeServico		text NOT NULL,
preco			decimal (6,2) NOT NULL,
idAdministradorDeCadastramento  decimal (4) NOT NULL,
FOREIGN KEY (idAdministradorDeCadastramento) REFERENCES T_EMPREGADO (idEmpregado) ON UPDATE CASCADE
);

-- ----------------------------------
-- Tabela T_AGENDAMENTO
-- ----------------------------------

DROP TABLE IF EXISTS T_AGENDAMENTO;
CREATE TABLE IF NOT EXISTS T_AGENDAMENTO (
idAgendamento		decimal (5) PRIMARY KEY,
dataAgendamento		date NOT NULL,
idServicoAgendado	decimal (4) NOT NULL,
idAnimal		decimal (4) NOT NULL,
idAtendenteDeAgendamento  decimal (4) NOT NULL,
FOREIGN KEY (idServicoAgendado) REFERENCES T_SERVICO (idServico) ON UPDATE CASCADE,
FOREIGN KEY (idAnimal) REFERENCES T_ANIMAL (idAnimal) ON UPDATE CASCADE,
FOREIGN KEY (idAtendenteDeAgendamento) REFERENCES T_EMPREGADO (idEmpregado) ON UPDATE CASCADE
);

-- ----------------------------------
-- Tabela T_FICHADEATENDIMENTO
-- ----------------------------------

DROP TABLE IF EXISTS T_FICHADEATENDIMENTO;
CREATE TABLE IF NOT EXISTS T_FICHADEATENDIMENTO (
numeroFicha		decimal (5) PRIMARY KEY,
dataAbertura		date NOT NULL,
dataFechamento		date NOT NULL,
idAgendamento		decimal (5) NOT NULL,
idAtendenteAbriuFicha	decimal (4) NOT NULL,
idAtendenteFechouFicha	decimal (4) NOT NULL,
statusFicha		text NOT NULL,
FOREIGN KEY (idAgendamento) REFERENCES T_AGENDAMENTO (idAgendamento) ON UPDATE CASCADE,
FOREIGN KEY (idAtendenteAbriuFicha) REFERENCES T_EMPREGADO (idEmpregado) ON UPDATE CASCADE,
FOREIGN KEY (idAtendenteFechouFicha) REFERENCES T_EMPREGADO (idEmpregado) ON UPDATE CASCADE
);

-- ----------------------------------
-- Tabela T_PRESCRICAO
-- ----------------------------------

DROP TABLE IF EXISTS T_PRESCRICAO;
CREATE TABLE IF NOT EXISTS T_PRESCRICAO (

idPrescricao		decimal(10) PRIMARY KEY,
numeroFicha		decimal (5) NOT NULL,
cpfVeterinario		bigint (11) NOT NULL,
idServico		decimal (4) NOT NULL,
dataPrescricaoServico	date NOT NULL,
idEmpregadoDeOrdenacao	decimal (4) NOT NULL,
dataFila		date NOT NULL,
FOREIGN KEY (numeroFicha) REFERENCES T_FICHADEATENDIMENTO (numeroFicha) ON UPDATE CASCADE,
FOREIGN KEY (cpfVeterinario) REFERENCES T_EMPREGADO (cpfEmpregado) ON UPDATE CASCADE,
FOREIGN KEY (idServico) REFERENCES T_SERVICO (idServico) ON UPDATE CASCADE,
FOREIGN KEY (idEmpregadoDeOrdenacao) REFERENCES T_EMPREGADO (idEmpregado) ON UPDATE CASCADE
);

-- ----------------------------------
-- Tabela T_BOX
-- ----------------------------------

DROP TABLE IF EXISTS T_BOX;
CREATE TABLE IF NOT EXISTS T_BOX (

numeroBox		decimal (5) PRIMARY KEY,
cpfVeterinario		bigint (11) NOT NULL,
FOREIGN KEY (cpfVeterinario) REFERENCES T_EMPREGADO (cpfEmpregado) ON UPDATE CASCADE
);

-- ----------------------------------
-- Tabela T_INTERNACAO
-- ----------------------------------

DROP TABLE IF EXISTS T_INTERNACAO;
CREATE TABLE IF NOT EXISTS T_INTERNACAO (
idInternacao		decimal (6) PRIMARY KEY,
dataInternacao		date NOT NULL,
numeroFicha		decimal (6) NOT NULL,
numeroBox		decimal (2) NOT NULL,
cpfVeterinario			 bigint (11) NOT NULL,
FOREIGN KEY (numeroFicha) REFERENCES T_FICHADEATENDIMENTO (numeroFicha) ON UPDATE CASCADE,
FOREIGN KEY (numeroBox) REFERENCES T_BOX (numeroBox) ON UPDATE CASCADE,
FOREIGN KEY (cpfVeterinario) REFERENCES T_EMPREGADO (cpfEmpregado) ON UPDATE CASCADE
);

