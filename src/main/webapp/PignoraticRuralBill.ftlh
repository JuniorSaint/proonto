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
        <div class="title"><strong> @_TITULO.DO.CABECALHO_@ </strong></div>
        <div class="hearder-main">
            <span style="text-align: left;"> <strong> @_TIPO.CEDULA_@ - @_NUMERO.CONTRATO_@</strong> </span>
            <span style="text-align: right;"> <strong> VENCIMENTO: @_VENCIMENTO.POR.EXTENSO_@</strong></span>
        </div>
        <div class="title">
            <strong> @_FINANCEIRO.VALOR.TOTAL_@ </strong>
        </div>
    </header>
    <div>
        <section>
            Aos vinte e cinco dias do mês de julho do ano de dois mil e vinte e
            dois, pagarei por esta Cédula Rural Pignoratícia nos termos da cláusula
            FORMA DE PAGAMENTO adiante descrita, a <strong> @_CREDORA_@ </strong>,
            pessoa jurídica de direito privado, inscrita no CNPJ sob
            @_CNPJ.CREDORA_@, com sede administrativa na @_TIPO.LOGRADOURO.CREDORA_@ @_LOGRADOURO.CREDORA_@,
            @_NUMERO.CREDORA_@, no município @_CIDADE.CREDORA_@ - @_UF.CREDORA_@, CEP: @_CEP.CREDORA_@, ou à
            sua ordem, a quantia de <strong> @_FINANCEIRO.VALORTOTAL_@ </strong> (@_FINANCEIRO.VALOREXTENSO_@ ),
            em moeda corrente nacional. O crédito deferido
            destina-se ao financiamento de custeio agrícola para sua produção de
            @_PRODUCAO_@, safra @_SAFRA_@, conforme documentos anexos,
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
        <ol>a) Juros moratórios à taxa efetiva de ${@_FINANCEIRO.TAXA.JUROS.EFETIVA.ANUAL_@ }%
            (@_FINANCEIRO.TAXA.JUROS.EFETIVA.ANUAL.POR.EXTENSO_@) ao ano;
        </ol>
    </div>
    <div style="text-align: right;">
        _________________________________________________________
    </div>
    <footer>
        <div class="footer">
            <p>Cédula Rural Pignoratícia</p>
            <p>Credora: @_CREDORA_@</p>
            <p>Devedor: @_DEVEDOR_@</p>
        </div>
    </footer>
</div>
<div>
    <header>
        <div class="title"><strong> @_TITULO.DO.CABECALHO_@ </strong></div>
        <div class="hearder-main">
            <span style="text-align: left;"> <strong> @_TIPO.CEDULA_@ - @_NUMERO.CONTRATO_@</strong> </span>
            <span style="text-align: right;"> <strong> VENCIMENTO: @_VENCIMENTO.POR.EXTENSO_@</strong></span>
        </div>
        <div class="title">
            <strong> @_FINANCEIRO.VALOR.TOTAL_@ </strong>
        </div>
    </header>
    <section>
        <ol>b) Juros remuneratórios à taxa efetiva de @_FINANCEIRO.TAXA.JUROS.EFETIVA.MENSAL_@ %
            (@_FINANCEIRO.TAXA.JUROS.EFETIVA.MENSAL.POR.EXTENSO_@)
            ao mês;
        </ol>
        <ol> c) Correção monetária pelo IGPM, ou qualquer outro índice que vier a substituí-lo;</ol>
        <ol> d) Multa de @_FINANCEIRO.MULTA_@ (@_FINANCEIRO.MULTA.POR.EXTENSO_@) calculada e exigível na data do
            pagamento, sobre os valores em atraso a
            serem parcialmente pagos e, na liquidação do saldo devedor, sobre o montante inadimplido.
        </ol>
    </section>

    <section>
        <strong> FORMA DE PAGAMENTO</strong>: Sem prejuízo do vencimento retro estipulado e das demais
        exigibilidades previstas nas demais cláusulas inclusive encargos financeiros básicos e adicionais, obrigo-me a
        pagar a @_CREDORA_@, o valor total descrito acima em parcela única, na data do vencimento da
        presente, sendo que o pagamento se dará mediante emissão de recibo pela credora.
    </section>

    <section>
        <strong>VENCIMENTO EXTRAORDINÁRIO</strong>: Declaro-me ciente de que na falta de cumprimento de quaisquer
        das obrigações por mim assumidas não só neste título, como em outros instrumentos que por ventura tenha firmado
        ou venha a firmar com a @_CREDORA_@, ou ainda, pela ocorrência de quaisquer dos
        casos de antecipação legal do vencimento, poderá a Cooperativa considerar vencidas, de pleno direito,
        as operações de crédito existentes e exigir o total da dívida delas resultante, independentemente de aviso
        extrajudicial ou interpelação judicial.
    </section>

    <section>
        <strong>PRAÇA DE PAGAMENTO</strong>: O pagamento será efetuado na praça de emissão deste título.
    </section>
    </section>
    <p><strong>GARANTIA</strong>: Os bens vinculados a esta cédula são os seguintes:</p>
    <p>Em garantia do fiel cumprimento desta cédula, o EMITENTE dá em PENHOR CEDULAR EM PRIMEIRO GRAU
        e sem concorrência de terceiros à CREDORA, a quantidade de
        @_CONTRATOS.CONTRATO.GARANTIAS.GARANTIA.QUANTIDADE_@ kg equivalente
        a @_CONTRATOS.CONTRATO.GARANTIAS.GARANTIA.DESCRICAO_@, </p>
    </section>
</div>
<div style="text-align: right;">
    _________________________________________________________
</div>

<footer>
    <div class="footer">
        <p>Cédula Rural Pignoratícia</p>
        <p>Credora: @_CREDORA_@</p>
        <p>Devedor: @_DEVEDOR_@</p>
    </div>
</footer>

</div>
<div>
    <header>
        <div class="title"><strong> @_TITULO.DO.CABECALHO_@ </strong></div>
        <div class="hearder-main">
            <span style="text-align: left;"> <strong> @_TIPO.CEDULA_@ - @_NUMERO.CONTRATO_@</strong> </span>
            <span style="text-align: right;"> <strong> VENCIMENTO: @_VENCIMENTO.POR.EXTENSO_@</strong></span>
        </div>
        <div class="title">
            <strong> @_FINANCEIRO.VALOR.TOTAL_@ </strong>
        </div>
    </header>
    <section>
        <p>tipo comercial da safra @_SAFRA_@, com colheita pendente,
            em área plantada conforme descrito no item abaixo, com as seguintes características:
            Padrão exportação com até @_UMIDADE_@% de umidade, @_IMPUREZA_@% de impurezas e máximo de @_AVARIADO_@% de
            avariados e ardidos</p>
    </section>

    <section>
        <strong>LOCALIZAÇÃO DO BEM VINCULADO</strong>>: As lavouras dadas em garantia nesta cédula encontram-se
        localizadas nas seguintes propriedades:
        <ol> @_TIPO_LOCALIZACAO_GARANTIA_@, zona rural, situada no município de @_CIDADE.GARANTIA_@ - @_UF.GARANTIA_@,
            de propriedade de ANA CRISTINA VIDOTO DE ABREU TARDOQUE, BRASILEIRA,
            CASADA, MONITORA DE VAN ESCOLAR, inscrito no CPF nº 661.623.191-72, imóvel devidamente registrado perante o
            Cartório de Registro de Imóveis da Comarca de @_CNS.COMARCA_GARANTIA_@ - @_CNS.UF.GARANTIA_@,
            sob a matrícula de nº @_MATRICULA.IMOVEL.GARANTIA_@.
        </ol>
    </section>

    <section>
        <p><strong> FIEL DEPOSITÁRIO</strong>>: Assume os encargos de fiel depositário dos bens dados em garantia -
            @_FIEL.DEPOSITARIO_@, @_FIEL.DEPOSITARIO.ESTADO.CIVIL_@, inscrito no CPF sob nº @_FIEL.DEPOSITARIO.CPF_@,
            residente e domiciliado na Fazenda 3 P, SN, Zona Rural, no município de @_FIEL.DEPOSITARIO.CIDADE_@ -
            @_FIEL.DEPOSITARIO.UF_@.
            O FIEL DEPOSITÁRIO declara, expressamente, aceitar e assumir tal obrigação, responsabilizando-se por todos
            os riscos, e sujeitando-se às cominações impostas ao depositário infiel.
        </p>
    </section>

    <section>
        <p><strong>AUTORIZAÇÃO ESPECIAL</strong>: Autorizo desde já a @_CREDORA_@, livre acesso aos imóveis, onde os
            bens dados em garantia encontram-se depositados, com finalidade de fiscalizar quando necessário, a sua
            correta utilização e manutenção.
        </p>
    </section>
    <section>
        <strong> <span style="text-align: center;"> @_CIDADE.ESTADO.DATA.CONTRATO_@ </span></strong>
        <br> <br>
        <strong>Devedor/ Emitente</strong>:

    </section>
    <section>
        _______________________________________________________________
        @_DEVEDOR_@, @_NACIONALIDEDE.DEVEDOR_@, @_ESTADO.CIVIL.DEVEDOR_@, @_PROFISSAO.DEVEDOR_@, portador da CIRG n.
        @_DOCUMENTO.DEVEDOR_@ emitida em @_DATA.EMISSAO.DOC.DEVEDOR_@
        e inscrito no CPF n. @_CPF.DEVEDOR_@, natural de @_CIDADE.NASCIMENTO.DEVEDOR_@ - RJ,
        nascido aos 21/12/1970, filho de
        @_FILIACAO1.DEVEDOR_@ e @_FILIACAO2.DEVEDOR_@, casado sob o regime de @_REGIME.DE.BENS.DEVEDOR_@ na vigência da
        Lei n.
        6.515/77 com Regina Resende, residente e domiciliado na @_LOGRADOURO.DEVEDOR_@, @_NUMERO.DEVEDOR_@, @_BAIRRO.DEVEDOR_@, no
        município de @_CIDADE.DEVEDOR_@ - @_UF.DEVEDOR_@.

    </section>
    <footer>
        <div class="footer">
            <p>Cédula Rural Pignoratícia</p>
            <p>Credora: @_CREDORA_@</p>
            <p>Devedor: @_DEVEDOR_@</p>
        </div>
    </footer>

</div>
<div>
    <header>
        <div class="title"><strong> @_TITULO.DO.CABECALHO_@ </strong></div>
        <div class="hearder-main">
            <span style="text-align: left;"> <strong> @_TIPO.CEDULA_@ - @_NUMERO.CONTRATO_@</strong> </span>
            <span style="text-align: right;"> <strong> VENCIMENTO: @_VENCIMENTO.POR.EXTENSO_@</strong></span>
        </div>
        <div class="title">
            <strong> @_FINANCEIRO.VALOR.TOTAL_@ </strong>
        </div>
    </header>
    <section>
        <strong> Fiel Depositário</strong>:
        <br> <br>
        _______________________________________________________________
        <strong> <span style="text-align: center;"> @_DEVEDOR_@ </span></strong> <br>
        <strong> <span style="text-align: center;"> @_CPF.DEVEDOR_@ </span> </strong>
        <br> <br>

    </section>
    <section>
        <strong>Credora</strong>:
        <br> <br>
        _______________________________________________________________
        <strong> <span style="text-align: center;"> @_CREDORA_@ </span></strong>
        <br>
        <strong> <span style="text-align: center;"> CNPJ: @_CNPJ.CREDORA_@ </span> </strong>
        <br> <br>

    </section>

    <section>
        <strong> Testemunhas</strong>:
        <br><br><br>

        _________________________________
        Nome:<br>
        CPF:
        <br><br>
        _________________________________
        Nome:<br>
        CPF:

    </section>

</div>
<div style="text-align: right;">
    _________________________________________________________
</div>
<footer>
    <div class="footer">
        <p>Cédula Rural Pignoratícia</p>
        <p>Credora: @_CREDORA_@</p>
        <p>Devedor: @_DEVEDOR_@</p>
    </div>
</footer>

</div>
</body>
</html>
