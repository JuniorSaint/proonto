<!DOCTYPE html>
<html lang="pt" xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
<head>
    <title>Spring Boot Form</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="/style.css"/>
</head>
<body>
<div>
    <header>
        <#include "/header-pignoratic.ftlh">
    </header>
    <div>
        <section>
            Aos vinte e cinco dias do mês de julho do ano de dois mil e vinte e
            dois, pagarei por esta Cédula Rural Pignoratícia nos termos da cláusula
            FORMA DE PAGAMENTO adiante descrita, a <strong> COOPERATIVA </strong>,
            pessoa jurídica de direito privado, inscrita no CNPJ sob
            25.258.258/0001-20, com sede administrativa na Rua das acácias,... ou à
            sua ordem, a quantia de <strong>${ tst.FINANCEIRO.VALORTOTAL ?string.currency} </strong> (${
            tst.FINANCEIRO.VALOREXTENSO } ), em moeda corrente nacional. O crédito deferido
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
        <ol>a) Juros moratórios à taxa efetiva de ${tst.FINANCEIRO.TAXAJUROSEFETIVAANUAL }% (---por extenso---) ao
            ano;
        </ol>
    </div>
    <div style="text-align: right;">
        _________________________________________________________
    </div>
    <footer>
        <#include "/footer-pignoratic.ftlh">
    </footer>
</div>
<div>
    <header>
        <#include "/header-pignoratic.ftlh">
    </header>
    <section>
        <ol>b) Juros remuneratórios à taxa efetiva de ${tst.FINANCEIRO.TAXAJUROSEFETIVAMENSAL}% (---por extenso---)
            ao mês;
        </ol>
        <ol> c) Correção monetária pelo IGPM, ou qualquer outro índice que vier a substituí-lo;</ol>
        <ol> d) Multa de 2% (dois por cento) calculada e exigível na data do pagamento, sobre os valores em atraso a
            serem parcialmente pagos e, na liquidação do saldo devedor, sobre o montante inadimplido.
        </ol>
    </section>

    <section>
        <strong> FORMA DE PAGAMENTO</strong>>: Sem prejuízo do vencimento retro estipulado e das demais
        exigibilidades
        previstas nas demais cláusulas inclusive encargos financeiros básicos e adicionais, obrigo-me a pagar a
        ${tst.APRESENTANTE.NOME ? upperCase}, o valor total descrito acima em parcela única, na data do vencimento da
        presente,
        sendo que o pagamento se dará mediante emissão de recibo pela credora.
    </section>

    <section>
        <strong>VENCIMENTO EXTRAORDINÁRIO</strong>>: Declaro-me ciente de que na falta de cumprimento de quaisquer
        das obrigações
        por mim assumidas não só neste título, como em outros instrumentos que por ventura tenha firmado ou venha
        a firmar com a ${tst.APRESENTANTE.NOME}, ou ainda, pela ocorrência de quaisquer dos
        casos de antecipação legal do vencimento, poderá a Cooperativa considerar vencidas, de pleno direito,
        as operações de crédito existentes e exigir o total da dívida delas resultante, independentemente de aviso
        extrajudicial ou interpelação judicial.
    </section>

    <section>
        <strong>PRAÇA DE PAGAMENTO</strong>: O pagamento será efetuado na praça de emissão deste título.
    </section>
    </section>
    <p><strong>GARANTIA</strong>: Os bens vinculados a esta cédula são os seguintes:</p>
    </section>
</div>
<div style="text-align: right;">
    _________________________________________________________
</div>
<footer>
    <#include "/footer-pignoratic.ftlh">
</footer>

</div>

</body>
</html>
