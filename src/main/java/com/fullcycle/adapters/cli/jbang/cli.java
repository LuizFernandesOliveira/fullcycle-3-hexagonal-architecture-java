///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS info.picocli:picocli:4.6.3
//INJECT com.fullcycle.adapters.cli.jbang.CLIService


import com.fullcycle.adapters.cli.jbang.CLIService;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Command(name = "cli", mixinStandardHelpOptions = true, version = "cli 0.1",
        description = "cli made with jbang")
class cli implements Callable<Integer> {
    private CLIService cliService;

    public cli() {
        cliService = new CLIService();
    }

    @Option(names = { "-o", "--option" }, description = "Command [GET, CREATE, UPDATE]")
    private String option;

    @Option(names = { "-i", "--product-id" }, description = "Product Id")
    private String id;

    @Option(names = { "-n", "--product-name" }, description = "Product Name")
    private String name;

    @Option(names = { "-p", "--product-price" }, description = "Product Price")
    private String price;

    public static void main(String... args) {
        int exitCode = new CommandLine(new cli()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception {
        cliService.execute(option, id, name, price);
        return 0;
    }
}
