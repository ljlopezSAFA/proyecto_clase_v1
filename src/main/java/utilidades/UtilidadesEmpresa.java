package utilidades;

import modelos.*;

import java.util.*;
import java.util.stream.Collectors;

public class UtilidadesEmpresa {


    public List<Empleado> getEmpleadosPorContrato(Empresa empresa, TipoContrato tipoContrato){

        List<Empleado> empleadosSolucion = new ArrayList<>();

        for(Empleado empleado : empresa.getEmpleados()){
            if(empleado.getContrato().getTipoContrato().equals(tipoContrato)){
                empleadosSolucion.add(empleado);
            }
        }
        return empleadosSolucion;

    }

    public List<Empleado> getEmpleadosPorContratoF2(Empresa empresa, TipoContrato tipoContrato){

        return empresa.getEmpleados()
                .stream()
                .filter(e-> e.getContrato().getTipoContrato().equals(tipoContrato))
                .toList();
    }


    public List<Empleado> getMileuristasOrdenadosPorSalario(Empresa empresa){

        List<Empleado> empleadosSolucion = new ArrayList<>();

        for(Empleado empleado : empresa.getEmpleados()){
            if(empleado.getContrato().getSalarioBase() >= 1000){
                empleadosSolucion.add(empleado);
            }
        }

        //Ordenamos por salario (menor a mayor)
        empleadosSolucion.sort(Comparator.comparing(e -> e.getContrato().getSalarioBase()));

        //Damos la vuelta a la lista (mayor a menor)
        Collections.reverse(empleadosSolucion);


        return empleadosSolucion;
    }

    public List<Empleado> getMileuristasOrdenadosPorSalarioF2(Empresa empresa){

        List<Empleado> empleadosFiltrado = empresa.getEmpleados()
                .stream()
                .filter(e-> e.getContrato().getSalarioBase() >=1000)
                .sorted(Comparator.comparing(e-> e.getContrato().getSalarioBase()))
                .toList();

        Collections.reverse(empleadosFiltrado);

        return empleadosFiltrado;
    }

    public double fondoSalarialEmpresa(Empresa empresa){
        Double fondoSalarialTotal = 0.0;

        for(Empleado empleado : empresa.getEmpleados()){
            fondoSalarialTotal += empleado.getContrato().getSalarioBase();
        }
        return fondoSalarialTotal;
    }

    public double fondoSalarialEmpresaF2(Empresa empresa){

        return empresa.getEmpleados()
                .stream()
                .mapToDouble(e-> e.getContrato().getSalarioBase())
                .sum();
    }


    public Empleado getMejorPagado(List<Empresa> empresas){

        List<Empleado> todosEmpleados = new ArrayList<>();
        Empleado elMejorPagado = null;

        for(Empresa empresa : empresas){
            todosEmpleados.addAll(empresa.getEmpleados());
        }

        for(Empleado empleado : todosEmpleados){
            if(elMejorPagado == null || empleado.getContrato().getSalarioBase()
                    > elMejorPagado.getContrato().getSalarioBase()){
                elMejorPagado = empleado;
            }
        }

        return  elMejorPagado;

    }

    public Empleado getMejorPagadoOrdenando(List<Empresa> empresas){

        List<Empleado> todosEmpleados = new ArrayList<>();

        for(Empresa empresa : empresas){
            todosEmpleados.addAll(empresa.getEmpleados());
        }

        todosEmpleados.sort(Comparator.comparing(e -> e.getContrato().getSalarioBase()));

        return todosEmpleados.get(todosEmpleados.size()-1);

    }

    public Empleado getMejorPagadoOrdenandoF2(List<Empresa> empresas){
        return (Empleado) UtilidadesListas.getLast(empresas.stream()
                .flatMap(e-> e.getEmpleados().stream())
                .sorted(Comparator.comparing(e -> e.getContrato().getSalarioBase()))
                .toList());

    }

    public Map<TipoContrato, List<Empleado>> getEmpleadosPorTipoContrato(Empresa empresa){

        Map<TipoContrato, List<Empleado>> mapaSolucion = new HashMap<>();

        for(Empleado empleado: empresa.getEmpleados()){

            if(mapaSolucion.containsKey(empleado.getContrato().getTipoContrato())){
                mapaSolucion.get(empleado.getContrato().getTipoContrato()).add(empleado);
            }else{
                mapaSolucion.put(empleado.getContrato().getTipoContrato(), List.of(empleado));
            }
        }
        return mapaSolucion;

    }

    public Map<TipoContrato, List<Empleado>> getEmpleadosPorTipoContratoV2(Empresa empresa){
       return  empresa.getEmpleados()
               .stream()
               .collect(Collectors.groupingBy(e-> e.getContrato().getTipoContrato()));

    }

    public Map<Empresa, Map<TipoContrato, List<Empleado>>> getEmpleadosPorTipoContrato(List<Empresa> empresas){

        Map<Empresa, Map<TipoContrato, List<Empleado>>> mapaSolucion = new HashMap<>();

        for(Empresa empresa : empresas){
            mapaSolucion.put(empresa, getEmpleadosPorTipoContrato(empresa));
        }

        return mapaSolucion;

    }

    public List<Empleado> getEmpleadosPymePracticasV2(List<Empresa> empresas){

        return empresas
                .stream()
                .filter(empresa-> empresa.getTipoEmpresa().equals(TipoEmpresa.PYME))
                .flatMap(empresa-> empresa.getEmpleados().stream())
                .filter(empleado -> empleado.getContrato().getTipoContrato().equals(TipoContrato.PRACTICAS))
                .toList();
    }

    public List<Empleado> getEmpleadosPymePracticas(List<Empresa> empresas){

        List<Empleado> empleadosSolucion = new ArrayList<>();

        for(Empresa empresa:empresas){
            if(empresa.getTipoEmpresa().equals(TipoEmpresa.PYME)){
                for(Empleado empleado : empresa.getEmpleados()){
                    if(empleado.getContrato().getTipoContrato().equals(TipoContrato.PRACTICAS)){
                        empleadosSolucion.add(empleado);
                    }
                }
            }
        }
        return empleadosSolucion;
    }

    public Map<Empresa,Empleado> getLosMejorPagadosPorEmpresa(List<Empresa> empresas){

        Map<Empresa,Empleado> mapaSolucion = new HashMap<>();

        for(Empresa empresa: empresas){
            mapaSolucion.put(empresa, getMejorPagado(List.of(empresa)));
        }

        return mapaSolucion;

    }










}
