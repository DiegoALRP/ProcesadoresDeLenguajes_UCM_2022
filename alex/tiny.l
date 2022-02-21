package alex;

%%
%line
%column
%class AnalizadorLexicoTiny
%type  UnidadLexica
%unicode

%{
  private ALexOperations ops;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
  public int columna() {return yycolumn+1;}
%}

%eofval{
  return ops.unidadEof();
%eofval}

%init{
  ops = new ALexOperations(this);
%init}

letra  = ([A-Z]|[a-z])
digitoPositivo = [1-9]
digito = ({digitoPositivo}|0)
parteEntera = ({digitoPositivo}{digito}* | 0)
parteDecimal = ({digito}* {digitoPositivo} | 0)
parteExponencial = [e,E] numeroEntero
ignorar = [ \r\b\n]
comentario = #[^\n]*
entero = int
real = real
bool = bool
true = true
false = false
and = and
or = or
not = not
string = string
null = null
procedimiento = proc
if = if
then = then
else = else
endif = endif
while = while
do = do
endwhile = endwhile
call = call
record = record
array = array
of = of
pointer = pointer
new = new
delete = delete
read = read
write = write
nl = nl
var = var
type = type 
identificador =  {letra} ({letra} | [0-9] | \_ )*
lit_cadena = \"[^\b,\n,\r]*\"
numeroEntero = [\+,\-]?{parteEntera}
numeroReal =  [\+,\-]?{parteEntera}(\.{parteDecimal}|{parteExponencial}|\.{parteDecimal}{parteExponencial})
mas = \+
menos = \-
por = \*
div = \/
par_aper = \(
par_cier = \)
corchete_apertura = \{
corchete_cierre = \}
corcheRect_apertura = \[
corcheRect_cierre = \]
igual = \=
igual_igual = \=\=
menor = <
mayor = >
menor_igual = <\=
mayor_igual = >\=
distinto = \!\=
sep_seccion = &&
puntoComa = ;
coma  = \,
mod = %
ampersand = &
flecha = \->
punto = \.
%%
{ignorar}                 {}
{comentario}              {}
{entero}                  {return ops.unidadEntero();}
{real}                    {return ops.unidadReal();}
{bool}                    {return ops.unidadBool();}
{true}                    {return ops.unidadTrue();}
{false}                   {return ops.unidadFalse();}
{and}                     {return ops.unidadAnd();}
{or}                      {return ops.unidadOr();}
{not}                     {return ops.unidadNot();}
{string}                  {return ops.unidadString();}
{null}                    {return ops.unidadNull();}
{procedimiento}           {return ops.unidadProcedimiento();}
{if}                      {return ops.unidadIf();}
{then}                    {return ops.unidadThen();}
{else}                    {return ops.unidadElse();}
{endif}                   {return ops.unidadEndIf();}
{while}                   {return ops.unidadWhile();}
{do}                      {return ops.unidadDo();}
{endwhile}                {return ops.unidadEndWhile();}
{call}                    {return ops.unidadCall();}
{record}                  {return ops.unidadRecord();}
{array}                   {return ops.unidadArray();}
{of}                      {return ops.unidadOf();}
{pointer}                 {return ops.unidadPointer();}
{new}                     {return ops.unidadNew();}
{delete}                  {return ops.unidadDelete();}
{read}                    {return ops.unidadRead();}
{write}                   {return ops.unidadWrite();}
{nl}                      {return ops.unidadNl();}
{var}                     {return ops.unidadVar();}
{type}                    {return ops.unidadType();}
{identificador}           {return ops.unidadId();}
{lit_cadena}              {return ops.unidadLitCadena();}
{numeroEntero}            {return ops.unidadNumEnt();}
{numeroReal}              {return ops.unidadNumReal();}
{mas}                     {return ops.unidadMas();}
{menos}                   {return ops.unidadMenos();}
{por}                     {return ops.unidadMul();}
{div}                     {return ops.unidadDiv();}
{mod}                     {return ops.unidadMod();}
{corchete_apertura}       {return ops.unidadCorcheteApertura();}
{corchete_cierre}         {return ops.unidadCorcheteCierre();}
{corcheRect_apertura}     {return ops.unidadCorcheRectApertura();}
{corcheRect_cierre}       {return ops.unidadCorcheRectCierre();}
{igual}                   {return ops.unidadIgual();}
{igual_igual}             {return ops.unidadIgualIgual();} 
{menor}                   {return ops.unidadMenor();}
{mayor}                   {return ops.unidadMayor();}
{menor_igual}             {return ops.unidadMenorIgual();}
{mayor_igual}             {return ops.unidadMayorIgual();}
{distinto}                {return ops.unidadDistinto();}
{par_aper}                {return ops.unidadParAper();}
{par_cier}                {return ops.unidadParCier();}
{sep_seccion}             {return ops.unidadSepSeccion();}
{puntoComa}               {return ops.unidadPuntoComa();}
{coma}                    {return ops.unidadComa();}
{ampersand}               {return ops.unidadAmpersand();}
{flecha}                  {return ops.unidadFlecha();}
{punto}                   {return ops.unidadPunto();}
[^]                       {ops.error();}  

