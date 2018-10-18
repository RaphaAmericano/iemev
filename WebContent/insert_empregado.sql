insert into T_EMPREGADO(cpfEmpregado, dataDeAdmissaoEmpregado, ramal, emailEmpregado, tipoEmpregado, idAdministradorDeCadastramento ) values ( 11111111111, "2018-10-17 00:00:00", 1, "fausto.silva@iemev.com.br", "administrador", 1);
insert into T_EMPREGADO(cpfEmpregado, dataDeAdmissaoEmpregado, ramal, emailEmpregado, tipoEmpregado, idAdministradorDeCadastramento ) values ( 22222222222, "2018-10-17 00:00:00", 1, "jose.datena@iemev.com.br", "veterinario", 1);
insert into T_EMPREGADO(cpfEmpregado, dataDeAdmissaoEmpregado, ramal, emailEmpregado, tipoEmpregado, idAdministradorDeCadastramento ) values ( 33333333333, "2018-10-17 00:00:00", 1, "galvao.bueno@iemev.com.br", "atendente", 1);

insert into T_ATENDENTE (cpfUsuario) values (333333333);
insert into T_ADMINISTRADOR (cpfUsuario) values (11111111111);
insert into T_VETERINARIO (cpfUsuario, crmv, especialidade) values (22222222222, 1111, "Cirurgia");

insert into T_CLIENTE(cpfUsuario, emailCliente, idAtendenteDeCadastramento) values (44444444444, "marcelo.rezende@iemev.com.br", 1)