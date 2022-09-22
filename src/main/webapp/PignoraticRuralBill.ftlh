<!DOCTYPE html>
<html lang="pt">
<head>
    <title>Spring Boot Form</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="/style.css"/>
</head>
<body>
<div class="title">CÉDULA RURAL PIGNORATÍCIA</div>
<div class="hearder-main">
    <span style="text-align: left;"> <strong>CRP - ${ pignor.documentNumber }</strong> </span>
    <span style="text-align: right;"> <strong> VENCIMENTO: ${ pignor.dueDate }</strong></span>
</div>
<div class="title">
    <strong> R$** ${ pignor.value } </strong>
</div>
<div>
    <section>
        Aos vinte e cinco dias do mês de julho do ano de dois mil e vinte e
        dois, pagarei por esta Cédula Rural Pignoratícia nos termos da cláusula
        FORMA DE PAGAMENTO adiante descrita, a <strong> COOPERATIVA </strong>,
        pessoa jurídica de direito privado, inscrita no CNPJ sob
        25.258.258/0001-20, com sede administrativa na Rua das acácias,... ou à
        sua ordem, a quantia de R$** <strong>${ pignor.value } </strong> (${
        pignor.writtenValue} ), em moeda corrente nacional. O crédito deferido
        destina-se ao financiamento de custeio agrícola para sua produção de
        {pignor.product}, safra {pignor.harvest}, conforme documentos anexos,
        e que será utilizado mediante liberação em conta produção.
    </section>

    <section>
        <strong
        >ENCARGO FINANCEIRO BÁSICO: Sobre os montantes fornecidos pela
            Cooperativa e os que forem devidos
        </strong>
        a título de despesas em decorrência deste instrumento, incidirão juros
        legais (art. 406 do Código Civil, c/c art. 161, § 1º do CTN)
        determinados pela aplicação da taxa praticada pela Fazenda Nacional, com
        base na correspondente taxa proporcional diária (ano de 360 dias). Os
        encargos aqui tratados serão calculados e debitados no último dia de
        cada mês, nas remições-proporcionalmente aos valores remidos, no
        vencimento e na liquidação da dívida, e exigidos junto às amortizações
        de principal, inclusive nas remições proporcionalmente aos seus valores
        nominais, no vencimento e na liquidação da dívida.
    </section>

    <section>
        <strong>ENCARGO FINANCEIRO ADICIONAL</strong>: Sobre os saldos devedores
        diários apresentados na conta vinculados a presente operação, incidirá
        encargo financeiro adicional determinado pela aplicação do IGPM-M
        debitados e exigíveis nas mesmas épocas dos encargos financeiros
        básicos, caso o IGP-M venha a ser extinto ou substituído, o índice
        criado para substituí-lo deverá ser adotado para correção dos valores
        financeiros.
    </section>

    <section>
        <strong>INADIMPLEMENTO DE OBRIGAÇÕES</strong>: No caso de descumprimento
        de qualquer obrigação legal ou convencional, ou no caso de vencimento
        antecipado da operação, serão exigidos, a partir do inadimplemento e
        sobre o valor inadimplido, os encargos financeiros abaixo, em
        substituição aos encargos de normalidade pactuados:
    </section>
    <p>a) Juros moratórios à taxa efetiva de 1,00% (um por cento) ao ano;</p>
</div>
<div style="text-align: right;">
    _________________________________________________________
</div>
<div class="footer">
    <p>Cédula Rural Pignoratícia</p>
    <p>Credora: Cooperativa Rural</p>
    <p>Devedor: João Ninguém</p>
</div>
</body>
</html>
