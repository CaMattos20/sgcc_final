# SGCC

O Sistema para Gestão de Condomínio Comercial (SGCC) abrange os processos relacionados ao uso de materiais, recepção e atenção aos usuários, locatários, locadores e clientes, bem como geração e pagamento do condomínio. Além disso, também realiza a gestão inteligente do consumo de água e energia elétrica, manutenção de elevadores, ambientes, limpeza, segurança patrimonial, incêndio, lixo, estacionamento e correio.


#### Entidades

Pessoas:
 * Id
 * Nome
 * Email
 * Telefone
 * Documento (CPF/CNPJ)
 * Valid From

Empresas:
 * Id
 * Nome
 * Email
 * Telefone
 * CNPJ
 * Valid From

	> Adicionar lista de funcionários

Funcionarios:
 * Id
 * Id usuario
 * Empresa
 * Status
 * Valid From
 * Valid To

	> Ajustar filtros
	> Ajustar formulário
		- Dropdown com funcionário
		- Dropdown com empresa

Prédios:
 * Id
 * Nome
 * Status
 * Valid From
 * Valid To

Salas Comerciais:
 * Id
 * Id do Predio
 * Andar
 * Sala
 * Tamanho
 * Valor da compra da sala comercial
 * Status
 * Valid From
 * Valid To

Locatários:
 * Id
 * Id empresa
 * Id sala comercial
 * Prazo pagamento condominio
 * Valor condominio
 * Status
 * Valid From
 * Valid To

Locadores:
 * Id
 * Id da empresa
 * Id sala comercial
 * Status
 * Valid From
 * Valid To

Pagamentos condomínio:
 * Id
 * Id locatário
 * Data
 * Valor

Entradas/Saidas:
 * Id
 * Id usuario
 * Id da sala
 * Data/hora
 * Entrada/saida