package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		//Referencias:
		
		
		
		//Instanciação da hora agora do Data-Hora:
		
		
		//Data atual com apenas data.
		LocalDate d01 = LocalDate.now();
		System.out.println("d01 = "+d01);
		//Data atual com horário,com fração de segundos incluso.
		LocalDateTime d02 = LocalDateTime.now();
		System.out.println("d02 = "+d02);
		//Data atual global(gerando 3 horas a frente do fuso do Brasil), com fração de segundos incluso.
		Instant d03 = Instant.now();
		System.out.println("d03 = "+d03);
		
		
		
		//Transformar Texto ISO 8601 em Data-Hora:
		
		
		
		//Transformando com apenas Data.
		LocalDate d04 = LocalDate.parse("2022-07-20");
		System.out.println("d04 = "+d04);
		//Transformando com Data e hora
		LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26");
		System.out.println("d05 = "+d05);
		//Transformando com Data e Hora Global.
		Instant d06 = Instant.parse("2022-07-20T01:30:26Z");
		System.out.println("d06 = "+d06);
		//Transformando com data e Hora Global,mas com fuso-horário brasileiro(considera-se o horário escrito o brasileiro e o resultado o correspondente ao GMT).
		Instant d07 = Instant.parse("2022-07-20T01:30:26-03:00");
		System.out.println("d07 = "+d07);
		
		
		//Formato Customizado:
		
		
		//Formato customizado com Data.
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate d08 = LocalDate.parse("20/07/2022", fmt1);
		System.out.println("d08 = "+d08);
		//Formato Customizado com Data e Hora.
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime d09 = LocalDateTime.parse("20/07/2022 01:30", fmt2);
		System.out.println("d09 = "+d09);
		//Formato Customizado com Data e Hora(Exemplo Com expressão dentro do argumento).
		LocalDateTime d009 = LocalDateTime.parse("06/09/2023 11:20", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		System.out.println("d009 = "+d009);
		
		
		//Instanciar Datas,a partir de dados isolados:
		
		//Dados isolads instanciados como Data.
		LocalDate d10 = LocalDate.of(2022, 7, 20);
		System.out.println("d10 = "+d10);
		//Dados isolados instanciados como Data e horário.
		LocalDateTime d11 = LocalDateTime.of(2022, 7, 20, 1, 30);
		System.out.println("d11 = "+d11);
		
		
		//Formatar Data em Texto em um formato customizado:
		
		
		//Data impressa com formato customizado.
		LocalDate d12 = LocalDate.parse("2022-07-20");
		DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		//Impressão:
		System.out.println("d12 = "+ d12.format(fmt3));
		//ou então pode fazer: 'System.out.println("d12 = "+ fmt3.format(d12));' Que irá apresentar o mesmo resultado.
		//ou então pode fazer: 'System.out.println("d12 = "+ d12.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));' Que irá realizar o mesmo resultado, com a diferença que logo após a execução será excluída pela coleta de lixo.
		
		//Data e Hora impressa com Formato Customizado.
		LocalDateTime d13 = LocalDateTime.parse("2023-08-06T11:56:00");
		DateTimeFormatter fmt4 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		//Impressão:
		System.out.println("d13 = "+d13.format(fmt4));
		//Ou então pode fazer: 'System.out.println("d13 = "+fmt4.format(d13));' Que irá apresentar o mesmo resultado.
		//Ou então pode fazer: 'System.out.println("d13 = "+d13.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));' Que irá apresentr o mesmo resultado, com a diferença que logo após a execução será excluída pela coleta de lixo.
		
		//Data e Hora Global impressa com Formato Customizado.
		Instant d14 = Instant.parse("2022-07-20T01:30:26Z");
		//DateTimeFormatter com especificação do fuso horário usado,que neste exemplo seria o fuso do sistema.
		DateTimeFormatter fmt5 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
		//Impressão: | OBS:impresso no horário de SP/Brasil:
		System.out.println("d14 = "+ fmt5.format(d14));
		
		//Opção Que especifica que seja no formato ISO 8601:
		
		
		//LocalDate com impressão em formato ISO 8601.
		LocalDate d15 = LocalDate.parse("2023-09-06");
		DateTimeFormatter fmt6 = DateTimeFormatter.ISO_DATE;
		System.out.println("d15 = "+d15);
		//LocalDateTime com impressão em formato ISO 8601:
		LocalDateTime d16 = LocalDateTime.parse("2023-09-07T11:30");
		DateTimeFormatter fmt7 = DateTimeFormatter.ISO_DATE_TIME;
		System.out.println("d16 = "+d16.format(fmt7));
		//Instant com impressão em formato ISO 8601:
		Instant d17 = Instant.parse("2023-09-07T11:30:26-03:00");
		DateTimeFormatter fmt8 = DateTimeFormatter.ISO_INSTANT;
		System.out.println("d17 = "+fmt8.format(d17));
		
		
		
		//Conversão de uma Data_Hora global para local:
		
		
		//Conversão de Instant para LocalDate,considerando o fuso do horário da máquina.
		Instant d18 = Instant.parse("2022-07-20T01:30:26Z");
		LocalDate d19 = LocalDate.ofInstant(d18, ZoneId.systemDefault());
		//impressão:
		System.out.println("d19 = "+d19);
		//Segundo Exemplo,considerando o fuso horário de Portugal.
		LocalDate d20 = LocalDate.ofInstant(d18, ZoneId.of("Portugal"));
		//impressão:
		System.out.println("d20 = "+d20);
		//Conversão de Instant para LocalDateTime:
		LocalDateTime d21 = LocalDateTime.ofInstant(d18, ZoneId.systemDefault());
		System.out.println("d21 = "+d21);
		LocalDateTime d22 = LocalDateTime.ofInstant(d18, ZoneId.of("Portugal"));
		System.out.println("d22 = "+d22);
		
		
		//Obtenção de dados de uma Data-Hora local:
		
		//Obtendo o dia da data Local:
		LocalDate d23 = LocalDate.parse("2022-07-20");
		System.out.println("d23 dia = "+ d23.getDayOfMonth());
		//obtendo o mês da data Local:
		System.out.println("d23 mês = "+ d23.getMonthValue());
		//Obtendo o Ano da data Local:
		System.out.println("d23 Ano = "+ d23.getYear());
		//Obtendo a hora de LocalDateTime.
		LocalDateTime d24 = LocalDateTime.parse("2022-07-20T01:30:26");
		System.out.println("d24 hora = "+ d24.getHour());
		//Obtendo os minutos de um LocalDateTime.
		System.out.println("d24 minuto = "+ d24.getMinute());
		//Obtendo os segundos de um LocalDateTime.
		System.out.println("d24 segundos = "+ d24.getSecond());
		
		
		//Cálculos com Data-Hora no Java:
		
		//Subtrai 7 dias da data declarada Local.
		LocalDate semanaAnteriorDate = d23.minusDays(7);
		System.out.println("semana Anterior = "+semanaAnteriorDate);
		//Soma 7 dias a data declarada Local.
		LocalDate semanaPosteriorDate = d23.plusDays(7);
		System.out.println("Semana Posterior = "+semanaPosteriorDate);
		
		
		//Cálculos com LocalDateTime:
		
		
		//Subtrai 7 dias da data e hora declarada Local.
		LocalDateTime semanaAnteriorDateTime = d24.minusDays(7);
		//Impressão:
		System.out.println("semana Anterior = "+semanaAnteriorDateTime);
		//Soma 7 dias a data declarada Local.
		LocalDateTime semanaPosteriorDateTime = d24.plusDays(7);
		//Impressão:
		System.out.println("Semana Posterior = "+semanaPosteriorDateTime);
		//Adicão de duas horas em relação ao horário declarado.
		LocalDateTime adicaoHorasDate = d24.plusHours(2);
		//Impressão:
		System.out.println("Adiantameno horas = "+adicaoHorasDate);
		
		
		//Cálculos com Instant:
		
		
		//remove 7 dias a Data global declarada.
		Instant semanaAnteriorInstant = d18.minus(7, ChronoUnit.DAYS);
		System.out.println("semana Anterior = "+semanaAnteriorInstant);
		//Adiciona 7 dias a Data global declarada.
		Instant semanaPosteriorInstant = d18.plus(7, ChronoUnit.DAYS);
		System.out.println("semana Posterior = "+semanaPosteriorInstant);
		
		
		//Cálculos de Duração entre duas Datas:
		
		//Cálcula intervalo de dias entre as duas Datas.
		Duration t1 = Duration.between(semanaAnteriorDateTime, d24);
		System.out.println("t1 dias: "+t1.toDays());
		//Cálcula intervalo de dias com tipo LocalDateTime entre as duas Datas.
		Duration t2 = Duration.between(semanaAnteriorDate.atTime(0 , 0), d23.atStartOfDay());
		System.out.println("t2 dias: "+t2.toDays());
		//Cálcula intervalo de dias com tipo Instant entre as duas Datas globais.
		Duration t3 = Duration.between(semanaAnteriorInstant, d18);
		System.out.println("t3 dias: "+t3.toDays());
		
		
		
		
		
		
		//Tipo Date e Calendar | versão do Java 8 e anteriores...
		
		
		
		
		//Instanciando Date hora-local com formato personalizado:
		//Instanciação do SimpleDateFormat:
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		//Instanciação dos Objetos:
		Date y1 = sdf1.parse("25/06/2018");
		Date y2 = sdf2.parse("22/08/2012 20:30:10");
		
		//Exibição:
		System.out.println(y1);
		System.out.println(y2);
		//Exibição com o formato personalizado definido anteriormente:
		System.out.println("y1 = "+sdf1.format(y1));
		System.out.println("y2 = "+sdf2.format(y2));
		
		
		//Criar Data atual com o tipo Date:
		Date x1 = new Date();
		System.out.println("Data atual x1 = "+x1);
		//Outra forma de criar data atual com o tipo Date(pega o instante do sistema,converte para millesegundos e cria a data a partir disso):
		Date x2 = new Date(System.currentTimeMillis());
		System.out.println("Data atual x2 = "+x2);
		
		//Criando data com hoário global no tipo Date,mas no fuso brasileiro:
		Date x3 = Date.from(Instant.parse("2018-06-25T15:42:07Z"));
		System.out.println("Instant,mas imprimindo em BR x3 = "+sdf2.format(x3));
		
		//Criando data com horário global no tipo Date:
		SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		sdf3.setTimeZone(TimeZone.getTimeZone("GMT"));
		//Exibição de horários declarados(inclusive formato personalizado),mas com fuso internacional(GMT):
		System.out.println("x1 Global = "+sdf3.format(x1));
		System.out.println("x2 Global = "+sdf3.format(x2));
		System.out.println("x3 Global = "+sdf3.format(x3));
		
		
		
		
		
		
		//Manipular Data com o tipo Calendar:
		
		
		
		
		//Instanciação horário Global com fuso máquina/BR:
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date d = Date.from(Instant.parse("2018-06-25T15:42:07Z"));
		System.out.println(sdf.format(d));
		//Calendário Instanciado com a data escolhida:
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		//Exemplo de adição de 4 horas na data:
		cal.add(Calendar.HOUR_OF_DAY, 4);
		//Atualização da váriavel 'd':
		d = cal.getTime();
		System.out.println(sdf.format(d));
		
		
		//Como obter dados de uma Data através do Calendar:
		
		
		//Obtendo os minutos da váriavel-Data definida:
		int minutes = cal.get(Calendar.MINUTE);
		System.out.println("Minutes = "+ minutes);
		//Obtendo o mês da váriavel-data definida:
		//OBS: '1' acrecentado ao cálculo devido a contagem de meses no Calendar começar no zero.
		int month = 1 + cal.get(Calendar.MONTH);
		System.out.println("Month = "+month);
		
	}

}
