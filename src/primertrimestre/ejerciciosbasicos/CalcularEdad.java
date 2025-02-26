package primertrimestre.ejerciciosbasicos;

import java.util.Scanner;
import java.time.Month;
import java.time.LocalDate;

public class CalcularEdad
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        String date = "";
        LocalDate currentDate = LocalDate.parse(date);

        int day = currentDate.getDayOfMonth();
        Month month = currentDate.getMonth();
        int year = currentDate.getYear();

        int userBirthYear = 0;
        int userBirthMonth = 0;
        int userBirthDay = 0;

        boolean validYear = false;
        boolean validMonth = false;
        boolean validDay = false;

        int resultYears = 0;
        int resultMonths = 0;
        int resultDays = 0;

        System.out.println("Hola, dime tu cumpleaños y te digo tu edad con precisión de cirujano. Dime primero el año en que naciste:");

        while (!validYear)
        {
            userBirthYear = scanner.nextInt();

            if (userBirthYear < 0)
            {
                System.out.println("No creo que hayas nacido antes que Cristo. Dime un año válido por favor");
            } else if (userBirthYear > year)
            {
                System.out.println("¿Cómo que todavía no has nacido?");
            } else
            {
                validYear = true;
            }
        }

        System.out.println("Hola, dime tu cumpleaños y te digo tu edad con precisión de cirujano. Dime primero el año en que naciste:");

        while (!validMonth)
        {
            userBirthMonth = scanner.nextInt();

            if ((userBirthMonth < 1) || (userBirthMonth > 12))
            {
                System.out.println("No puedes haber nacido en el mes " + userBirthMonth + ". Dime un mes válido por favor");
            } else
            {
                validMonth = true;
            }
        }

        System.out.println("Hola, dime tu cumpleaños y te digo tu edad con precisión de cirujano. Dime primero el año en que naciste:");

        while (!validDay)
        {
            userBirthDay = scanner.nextInt();

            if (userBirthDay > 0)
            {
                switch (userBirthMonth)
                {
                    case 1:
                        if (userBirthDay > 31)
                        {
                            System.out.println("Enero no tiene " + userBirthDay + " días. Dime un día válido:");
                        } else
                        {
                            validDay = true;
                        }
                        break;

                    case 2:
                        if (userBirthDay > 29)
                        {
                            System.out.println("Febrero no puede tener " + userBirthDay + " días. Dime un día válido:");
                        } else if (userBirthDay == 29) // Si no es un año bisiesto.
                        {
                            if ((userBirthYear % 4) != 0)
                            {
                                System.out.println("El año " + userBirthYear + " no fue bisiesto. Dime un día válido:");
                            }
                        } else
                        {
                            validDay = true;
                        }
                        break;

                    case 3:
                        if (userBirthDay > 31)
                        {
                            System.out.println("Marzo no tiene " + userBirthDay + " días. Dime un día válido:");
                        } else
                        {
                            validDay = true;
                        }
                        break;

                    case 4:
                        if (userBirthDay > 30)
                        {
                            System.out.println("Abril no tiene " + userBirthDay + " días. Dime un día válido:");
                        } else
                        {
                            validDay = true;
                        }
                        break;

                    case 5:
                        if (userBirthDay > 31)
                        {
                            System.out.println("Mayo no tiene " + userBirthDay + " días. Dime un día válido:");
                        } else
                        {
                            validDay = true;
                        }
                        break;

                    case 6:
                        if (userBirthDay > 30)
                        {
                            System.out.println("Junio no tiene " + userBirthDay + " días. Dime un día válido:");
                        } else
                        {
                            validDay = true;
                        }
                        break;

                    case 7:
                        if (userBirthDay > 31)
                        {
                            System.out.println("Julio no tiene " + userBirthDay + " días. Dime un día válido:");
                        } else
                        {
                            validDay = true;
                        }
                        break;

                    case 8:
                        if (userBirthDay > 31)
                        {
                            System.out.println("Agosto no tiene " + userBirthDay + " días. Dime un día válido:");
                        } else
                        {
                            validDay = true;
                        }
                        break;

                    case 9:
                        if (userBirthDay > 30)
                        {
                            System.out.println("Septiembre no tiene " + userBirthDay + " días. Dime un día válido:");
                        } else
                        {
                            validDay = true;
                        }
                        break;

                    case 10:
                        if (userBirthDay > 31)
                        {
                            System.out.println("Octubre no tiene " + userBirthDay + " días. Dime un día válido:");
                        } else
                        {
                            validDay = true;
                        }
                        break;

                    case 11:
                        if (userBirthDay > 30)
                        {
                            System.out.println("Noviembre no tiene " + userBirthDay + " días. Dime un día válido:");
                        } else
                        {
                            validDay = true;
                        }
                        break;

                    case 12:
                        if (userBirthDay > 31)
                        {
                            System.out.println("Diciembre no tiene " + userBirthDay + " días. Dime un día válido:");
                        } else
                        {
                            validDay = true;
                        }
                        break;
                }
            } else
            {
                System.out.println("No puedes haber nacido en el día " + userBirthDay + "Dime un día válido.");
            }
        }

        //if (month < userBirthMonth)
        //{
//            resultYears = year - userBirthYear;
//        }
    }
}
