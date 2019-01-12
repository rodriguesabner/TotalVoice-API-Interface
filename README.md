# TotalVoice-API---Interface

Eu criei esse software porquê no site da TotalVoice não tinha encontrado nenhum exemplo usando uma interface gráfica.

Foi e é bem útil, espero poder ajuda-los de alguma forma.

![Screenshot](https://github.com/abnerrodrigues2/TotalVoice-API---Interface/blob/master/Screenshot_1.png)

------------------------------------------------------------------------------------------------------------------------------------

Nome da Pessoa: É o nome que será falado na ligação.
Telefone: O número que será usado para a ligação, formato: (XX)91234-5678/(XX)1234-5678 (Ligações Brasileiras)
Voz: voz que será usada na ligação. Opções: br-Vitoria, br-Ricardo.

*A mensagem está dentro do botão "Realizar Ligação", você poderá altera-la.

Mensagem:

        try {
            "Olá! O seu amigo: " + camponome.getText() + " chegou, podemos autorizar a entrada? Digite 1, para sim, ou 2, para não", //Mensagem
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

ID da ligação: será mostrado assim que o botão for acionado.

Último campo vazio, será mostrado como o usuário interagiu. 
