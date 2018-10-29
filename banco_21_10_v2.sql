DROP TABLE IF EXISTS T_PESSOA;
CREATE TABLE T_PESSOA (
cpf			bigint (11) PRIMARY KEY,
rg			bigint (9) NOT NULL,
nome			text NOT NULL,
endereco		text NOT NULL,
telefoneResidencial	varchar (11) NOT NULL,
celular			decimalvarchar (11) NOT NULL,
dataDeNascimento	date NOT NULL
);

DROP TABLE IF EXISTS T_EMPREGADO;
CREATE TABLE T_EMPREGADO (
cpfEmpregado		bigint (11) ,
idEmpregado		INTEGER NOT NULL PRIMARY KEY,
dataDeAdmissaoEmpregado	date NOT NULL,
ramal			decimal (4) NOT NULL,
emailEmpregado		text NOT NULL,
senha			decimal (4) NOT NULL DEFAULT 0000,
indicadorNovaSenha	boolean NOT NULL DEFAULT 1,
tipoEmpregado		text NOT NULL,
idAdministradorDeCadastramento	decimal(4) NOT NULL,
FOREIGN KEY (cpfEmpregado) REFERENCES T_PESSOA (cpf) ON UPDATE CASCADE,
FOREIGN KEY (idAdministradorDeCadastramento) REFERENCES T_EMPREGADO (idEmpregado) ON UPDATE CASCADE
);

DROP TABLE IF EXISTS T_AGENDAMENTO;
CREATE TABLE T_AGENDAMENTO (
idAgendamento		INTEGER PRIMARY KEY,
dataAgendamento		date NOT NULL,
idServicoAgendado	INTEGER NOT NULL,
idAnimal		INTEGER NOT NULL,
idAtendenteDeAgendamento  INTEGER NOT NULL,
FOREIGN KEY (idServicoAgendado) REFERENCES T_SERVICO (idServico) ON UPDATE CASCADE,
FOREIGN KEY (idAnimal) REFERENCES T_ANIMAL (idAnimal) ON UPDATE CASCADE,
FOREIGN KEY (idAtendenteDeAgendamento) REFERENCES T_EMPREGADO (idEmpregado) ON UPDATE CASCADE
);

DROP TABLE IF EXISTS T_ANIMAL;
CREATE TABLE T_ANIMAL (
--idAnimal		decimal (4) PRIMARY KEY AUTOINCREMENT,
idAnimal		integer PRIMARY KEY AUTOINCREMENT,
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

DROP TABLE IF EXISTS T_ATENDENTE;
CREATE TABLE T_ATENDENTE (
cpfUsuario		bigint (11) PRIMARY KEY,
FOREIGN KEY (cpfUsuario) REFERENCES T_PESSOA (cpf) ON UPDATE CASCADE
);

DROP TABLE IF EXISTS T_ADMINISTRADOR;
CREATE TABLE T_ADMINISTRADOR (
cpfUsuario		bigint (11) PRIMARY KEY,
FOREIGN KEY (cpfUsuario) REFERENCES T_PESSOA (cpf) ON UPDATE CASCADE
);

DROP TABLE IF EXISTS T_BOX;
CREATE TABLE T_BOX (
numeroBox		decimal (5) PRIMARY KEY,
cpfVeterinario		bigint (11) NOT NULL,
FOREIGN KEY (cpfVeterinario) REFERENCES T_EMPREGADO (cpfEmpregado) ON UPDATE CASCADE
);

DROP TABLE IF EXISTS T_CLIENTE;
CREATE TABLE T_CLIENTE (
cpfUsuario		bigint (11) PRIMARY KEY,
emailCliente		text NOT NULL,
idAtendenteDeCadastramento  decimal (4) NOT NULL,
FOREIGN KEY (cpfUsuario) REFERENCES T_PESSOA (cpf) ON UPDATE CASCADE,
FOREIGN KEY (idAtendenteDeCadastramento) REFERENCES T_EMPREGADO (idEmpregado) ON UPDATE CASCADE
);

DROP TABLE IF EXISTS T_FICHADEATENDIMENTO;
CREATE TABLE T_FICHADEATENDIMENTO (
numeroFicha		INTEGER PRIMARY KEY,
dataAbertura		date NOT NULL DEFAULT (datetime('now', 'localtime') ),
dataFechamento		date NOT NULL DEFAULT (datetime('now', 'localtime') ),
idAnimal		integer NOT NULL,
idAtendenteAbriuFicha	decimal (4) NOT NULL,
idAtendenteFechouFicha	decimal (4) NOT NULL DEFAULT 0,
statusFicha		text NOT NULL DEFAULT "aberta",
FOREIGN KEY (idAnimal) REFERENCES T_ANIMAL (idAnimal) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (idAtendenteAbriuFicha) REFERENCES T_EMPREGADO (idEmpregado) ON UPDATE CASCADE,
FOREIGN KEY (idAtendenteFechouFicha) REFERENCES T_EMPREGADO (idEmpregado) ON UPDATE CASCADE
);

DROP TABLE IF EXISTS T_INTERNACAO;
CREATE TABLE T_INTERNACAO (
idInternacao		decimal (6) PRIMARY KEY,
dataInternacao		date NOT NULL,
numeroFicha		decimal (6) NOT NULL,
numeroBox		decimal (2) NOT NULL,
cpfVeterinario			 bigint (11) NOT NULL,
FOREIGN KEY (numeroFicha) REFERENCES T_FICHADEATENDIMENTO (numeroFicha) ON UPDATE CASCADE,
FOREIGN KEY (numeroBox) REFERENCES T_BOX (numeroBox) ON UPDATE CASCADE,
FOREIGN KEY (cpfVeterinario) REFERENCES T_EMPREGADO (cpfEmpregado) ON UPDATE CASCADE
);

DROP TABLE IF EXISTS T_PRESCRICAO;
CREATE TABLE T_PRESCRICAO (
idPrescricao		integer PRIMARY KEY,
numeroFicha		integer (5) NOT NULL,
cpfVeterinario		bigint (11) NOT NULL,
idServico		decimal (4) NOT NULL,
dataPrescricaoServico	date NOT NULL DEFAULT (datetime('now', 'localtime') ),
idEmpregadoDeOrdenacao	decimal (4) NOT NULL,
dataFila		date NOT NULL DEFAULT 0,
FOREIGN KEY (numeroFicha) REFERENCES T_FICHADEATENDIMENTO (numeroFicha) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (cpfVeterinario) REFERENCES T_EMPREGADO (cpfEmpregado) ON UPDATE CASCADE,
FOREIGN KEY (idServico) REFERENCES T_SERVICO (idServico) ON UPDATE CASCADE,
FOREIGN KEY (idEmpregadoDeOrdenacao) REFERENCES T_EMPREGADO (idEmpregado) ON UPDATE CASCADE
);

DROP TABLE IF EXISTS T_SERVICO;
CREATE TABLE T_SERVICO (
idServico		integer PRIMARY KEY,
categoria		text NOT NULL,
nomeServico		text NOT NULL,
preco			decimal (6,2) NOT NULL,
idAdministradorDeCadastramento  decimal (4) NOT NULL,
FOREIGN KEY (idAdministradorDeCadastramento) REFERENCES T_EMPREGADO (idEmpregado) ON UPDATE CASCADE
);

DROP TABLE IF EXISTS T_VETERINARIO;
CREATE TABLE T_VETERINARIO (
cpfUsuario		bigint (11) PRIMARY KEY,
crmv			decimal(8) NOT NULL,
especialidade		text NOT NULL,
FOREIGN KEY (cpfUsuario) REFERENCES T_PESSOA (cpf) ON UPDATE CASCADE
);