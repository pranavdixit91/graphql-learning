package com.pranav.graphql.exception;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GraphQLExceptionHandler extends DataFetcherExceptionResolverAdapter {

    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment dataFetchingEnvironment) {
        return GraphqlErrorBuilder.newError()
                .message(ex.getMessage())
                .path(List.of(dataFetchingEnvironment.getFieldDefinition().getName()))
                .errorType(org.springframework.graphql.execution.ErrorType.BAD_REQUEST)
                .build();
    }
}