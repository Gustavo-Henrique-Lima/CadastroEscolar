let qtdDisc=0;
let qtdAlun=0;
let qtdEsc=0;
const url ="http://localhost:8081/";

function fazGet(url)
{
    let request = new XMLHttpRequest();
    request.open("GET",url,false);
    request.send();
    return request.responseText;
}

function criaLinha(info,tipo)
{
    nome=document.createElement("p");
    nome.innerHTML=info+" "+tipo;
    return nome;
}
function getDisciplina()
{
    const data=fazGet(url+"turmas");
    let disciplinas=JSON.parse(data);
    let tabela=document.getElementById("tabela");
    disciplinas.forEach(element => 
    {
        qtdDisc++;   
    });
    let linha=criaLinha(qtdDisc,"turmas espalhados por");
    tabela.appendChild(linha);
}

function getAlunos()
{
    const data=fazGet(url+"alunos");
    let alunos=JSON.parse(data);
    alunos.forEach(element => {
        qtdAlun++;
    });
    linha=criaLinha(qtdAlun,"alunos, divididos em ");
    tabela.appendChild(linha);
}

function getEscolas()
{
    const data=fazGet(url+"escolas");
    let escolas=JSON.parse(data);
    escolas.forEach(element => {
        qtdEsc++;
    });
    
    linha=criaLinha(qtdEsc,"escolas");
    tabela.appendChild(linha);
}
function main()
{
   getAlunos();
   getDisciplina();
   getEscolas();
}